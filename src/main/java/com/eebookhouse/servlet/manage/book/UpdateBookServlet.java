package com.eebookhouse.servlet.manage.book;

import com.eebookhouse.entity.Book;
import com.eebookhouse.service.BookService;
import com.eebookhouse.service.Impl.BookServiceImpl;
import com.eebookhouse.utils.DateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet("/book/manage/update")
public class UpdateBookServlet extends HttpServlet {

    private BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int book_id = Integer.parseInt(req.getParameter("book_id"));
        String book_name = req.getParameter("bookname");
        String type = req.getParameter("type");
        String isbn = req.getParameter("isbn");
        String writer = req.getParameter("writer");
        String publisher = req.getParameter("publisher");
        String intro = req.getParameter("intro");
        Double price = Double.parseDouble(req.getParameter("price"));
        Integer remaining = Integer.parseInt(req.getParameter("remaining"));
        String picture = req.getParameter("picture");
        String date = DateUtil.changeStringByFormat(req.getParameter("date"),DateUtil.HTML_DATE);
        if(book_id != 0) {
            Book book = service.getBookById(book_id);
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
            if (!service.updateBook(book)) {
                req.getSession().setAttribute("book-update-failure", new Object());
            }else{
                resp.sendRedirect("/eebookhouse/book_detailed?book_id="+book.getId());
                return;
            }
        }else {
            req.getSession().setAttribute("book-update-failure", new Object());
        }
        resp.sendRedirect("/eebookhouse/book_manage?book_id=" + book_id);
    }
}
