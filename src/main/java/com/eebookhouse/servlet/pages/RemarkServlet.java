package com.eebookhouse.servlet.pages;

import com.eebookhouse.entity.Book;
import com.eebookhouse.entity.Remark;
import com.eebookhouse.entity.User;
import com.eebookhouse.service.BookService;
import com.eebookhouse.service.Impl.BookServiceImpl;
import com.eebookhouse.service.Impl.RemarkServiceImpl;
import com.eebookhouse.service.Impl.UserServiceImpl;
import com.eebookhouse.service.RemarkService;
import com.eebookhouse.utils.DateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/remark")
public class RemarkServlet extends HttpServlet {

    private RemarkService service;

    @Override
    public void init() throws ServletException {
        service = new RemarkServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer book_id = Integer.parseInt(req.getParameter("book_id"));
        if(book_id != 0){
            List<Remark> list = service.getRemarkListByBookId(book_id);
            req.setAttribute("remark_list",list);
            req.setAttribute("book_id",book_id);
        }
        if (req.getSession().getAttribute("remark-add-failure") != null) {
            req.setAttribute("remark-add-failure", true);
            req.getSession().removeAttribute("remark-add-failure");
        }
        if (req.getSession().getAttribute("remark-delete-failure") != null) {
            req.setAttribute("remark-delete-failure", true);
            req.getSession().removeAttribute("remark-delete-failure");
        }
        req.getRequestDispatcher("/remark.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer book_id = Integer.parseInt(req.getParameter("book_id"));
        resp.sendRedirect("/eebookhouse/remark?book_id=" + book_id);
    }

}
