package com.eebookhouse.servlet.manage.user;

import com.eebookhouse.entity.User;
import com.eebookhouse.service.Impl.UserServiceImpl;
import com.eebookhouse.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userinfo/update")
public class UpdateUserServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String postcode = req.getParameter("postcode");
        User user = (User)req.getSession().getAttribute("user");
        if(user != null) {
            User user_update = service.getUserById(user.getId());
            user_update.setUsername(username);
            user_update.setUserpass(userpass);
            user_update.setEmail(email);
            user_update.setAddress(address);
            user_update.setPostcode(postcode);
            if(service.updateUser(user_update)){
                req.getSession().setAttribute("user",user_update);
            }
        }
        resp.sendRedirect("/eebookhouse/userinfo");
    }
}
