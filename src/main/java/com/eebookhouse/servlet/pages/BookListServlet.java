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

@WebServlet("/book_list")
public class BookListServlet extends HttpServlet {

    private BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type!= null && !(type.equals(""))){
            List<Book> list = service.getBookListByType(type);
            req.setAttribute("book_list",list);
        }
        req.getRequestDispatcher("/book_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        if(search!= null && !(search.equals(""))){
            List<Book> list = service.getBookListBySearch(search);
            req.setAttribute("book_list",list);
        }
        this.doGet(req,resp);
    }

}
