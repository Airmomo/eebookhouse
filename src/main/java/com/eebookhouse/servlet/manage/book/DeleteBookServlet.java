package com.eebookhouse.servlet.manage.book;

import com.eebookhouse.entity.User;
import com.eebookhouse.service.BookService;
import com.eebookhouse.service.Impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/book/manage/delete")
public class DeleteBookServlet extends HttpServlet {

    private BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer book_id = Integer.parseInt(req.getParameter("book_id"));
        if(!service.deleteBookById(book_id)){
            req.getSession().setAttribute("book-delete-failure", new Object());
        }
        resp.sendRedirect("/eebookhouse/index");
    }

}
