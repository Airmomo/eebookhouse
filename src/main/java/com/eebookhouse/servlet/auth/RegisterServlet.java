package com.eebookhouse.servlet.auth;

import com.eebookhouse.service.Impl.UserServiceImpl;
import com.eebookhouse.service.UserService;
import jakarta.servlet.ServletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            req.getRequestDispatcher("/login").forward(req, resp);
            return;
        }
        if (req.getSession().getAttribute("register-failure") != null) {
            req.setAttribute("failure", true);
            req.getSession().removeAttribute("register-failure");
        }
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> map = req.getParameterMap();

        if(map.containsKey("username") && map.containsKey("password")){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (service.register(username, password, req.getSession())) {
                req.removeAttribute("failure");
            } else {
                req.getSession().setAttribute("register-failure", new Object());
            }
        }else{
            req.getSession().setAttribute("register-failure", new Object());
        }
        this.doGet(req, resp);
    }

}
