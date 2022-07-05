package com.eebookhouse.servlet.pages;

import com.eebookhouse.entity.Book;
import com.eebookhouse.service.BookService;
import com.eebookhouse.service.Impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/book_detailed")
public class BookDetailedServlet extends HttpServlet {

    private BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int book_id = Integer.parseInt(req.getParameter("book_id"));
        Book book = service.getBookById(book_id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/book_detailed.jsp").forward(req,resp);
    }
}
