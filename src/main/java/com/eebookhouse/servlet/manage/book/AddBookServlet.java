package com.eebookhouse.servlet.manage.book;

import com.eebookhouse.entity.Book;
import com.eebookhouse.service.BookService;
import com.eebookhouse.service.Impl.BookServiceImpl;
import com.eebookhouse.utils.AsciiUtil;
import com.eebookhouse.utils.DateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet("/book/manage/add")
public class AddBookServlet extends HttpServlet {

    private BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String book_name = req.getParameter("bookname");
        String type = req.getParameter("type");
        String isbn = req.getParameter("isbn");
        String writer = req.getParameter("writer");
        String publisher = req.getParameter("publisher");
        String intro = req.getParameter("intro");
        Double price = Double.parseDouble(req.getParameter("price"));
        Integer remaining = Integer.parseInt(req.getParameter("remaining"));
        String picture = req.getParameter("picture");
        String date = DateUtil.changeStringByFormat(req.getParameter("date"), DateUtil.HTML_DATE);

        Book book = service.getBookByName(book_name);
        if(book == null){
            book = new Book();
            book.setBookname(book_name);
            book.setType(type);
            book.setIsbn(isbn);
            book.setIntro(intro);
            book.setWriter(writer);
            book.setPublisher(publisher);
            book.setPrice(price);
            book.setRemaining(remaining);
            book.setPicture(picture);
            book.setDate(date);
            if (!service.addBook(book)) {
                req.getSession().setAttribute("book-add-failure", new Object());
            }else{
                book = service.getBookByName(book.getBookname());
                resp.sendRedirect("/eebookhouse/book_detailed?book_id="+book.getId());
                return;
            }
        }else{
            req.getSession().setAttribute("book-add-failure", new Object());
        }
        resp.sendRedirect("/eebookhouse/book_manage");
    }
}
