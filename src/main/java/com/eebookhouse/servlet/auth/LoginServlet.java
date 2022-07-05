package com.eebookhouse.servlet.auth;

import com.eebookhouse.service.Impl.UserServiceImpl;
import com.eebookhouse.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            String username = null;
            String password = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) username = cookie.getValue();
                if (cookie.getName().equals("password")) password = cookie.getValue();
            }
            if (username != null && password != null) {
                if (service.auth(username, password, req.getSession())) {
                    resp.sendRedirect("index");
                    return;
                }
            }
        }
        if (req.getSession().getAttribute("user") != null) {
            resp.sendRedirect("index");
            return;
        }
        if (req.getSession().getAttribute("login-failure") != null) {
            req.setAttribute("failure", true);
            req.getSession().removeAttribute("login-failure");
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> map = req.getParameterMap();

        if(map.containsKey("username") && map.containsKey("password")){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (service.auth(username, password, req.getSession())) {
                if (map.containsKey("remember-me")) {   //若勾选了勾选框，那么会保存此表单信息
                    Cookie cookie_username = new Cookie("username", username);
                    cookie_username.setMaxAge(60 * 60 * 24 * 7);
                    Cookie cookie_password = new Cookie("password", password);
                    cookie_password.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(cookie_username);
                    resp.addCookie(cookie_password);
                }
                req.removeAttribute("failure");
            } else {
                req.getSession().setAttribute("login-failure", new Object());
            }
        }else{
            req.getSession().setAttribute("login-failure", new Object());
        }
        this.doGet(req, resp);
    }
}