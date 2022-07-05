package com.eebookhouse.servlet.pages;

import com.eebookhouse.entity.Book;
import com.eebookhouse.entity.User;
import com.eebookhouse.service.BookService;
import com.eebookhouse.service.Impl.BookServiceImpl;
import com.eebookhouse.service.Impl.UserServiceImpl;
import com.eebookhouse.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userinfo")
public class UserManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user-update-failure") != null) {
            req.setAttribute("user-update-failure", true);
            req.getSession().removeAttribute("user-update-failure");
        }
        req.getRequestDispatcher("/user_manage.jsp").forward(req,resp);
    }

}
