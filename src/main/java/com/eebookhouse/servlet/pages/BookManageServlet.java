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

@WebServlet("/book_manage")
public class BookManageServlet extends HttpServlet {

    private BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("book-add-failure") != null) {
            req.setAttribute("failure", true);
            req.getSession().removeAttribute("book-add-failure");
        }
        if (req.getSession().getAttribute("book-update-failure") != null) {
            req.setAttribute("failure", true);
            req.getSession().removeAttribute("book-update-failure");
        }
        String book_id  = req.getParameter("book_id");
        if (book_id != null){
            int id = Integer.parseInt(book_id);
            Book book = service.getBookById(id);
            if (book != null)
                req.setAttribute("book", book);
            req.getRequestDispatcher("/book_update.jsp").forward(req,resp);
        }else{
            req.removeAttribute("book");
            req.getRequestDispatcher("/book_add.jsp").forward(req,resp);
        }
    }

}

