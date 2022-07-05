package com.eebookhouse.servlet.manage.remark;

import com.eebookhouse.entity.Remark;
import com.eebookhouse.entity.User;
import com.eebookhouse.service.BookService;
import com.eebookhouse.service.Impl.BookServiceImpl;
import com.eebookhouse.service.Impl.RemarkServiceImpl;
import com.eebookhouse.service.RemarkService;
import com.eebookhouse.utils.DateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/remark/add")
public class AddRemarkServlet extends HttpServlet {

    private RemarkService remarkServiceservice;
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        remarkServiceservice = new RemarkServiceImpl();
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer book_id = Integer.parseInt(req.getParameter("book_id"));
        Integer grade = 5;//当然是默认好评啦！Integer.parseInt(req.getParameter("grade"));
        String remark_str = req.getParameter("remark");
        String date = DateUtil.dateToString(new Date());
        if(!remark_str.equals("")){
            Remark remark = new Remark();
            remark.setBook(bookService.getBookById(book_id));
            remark.setUser((User) req.getSession().getAttribute("user"));
            remark.setGrade(grade);
            remark.setRemark(remark_str);
            remark.setDate(date);
            if(!remarkServiceservice.addRemark(remark)){
                req.getSession().setAttribute("remark-add-failure", new Object());
            }
        }else{
            req.getSession().setAttribute("remark-add-failure", new Object());
        }
        resp.sendRedirect("/eebookhouse/remark?book_id=" + book_id);
    }

}
