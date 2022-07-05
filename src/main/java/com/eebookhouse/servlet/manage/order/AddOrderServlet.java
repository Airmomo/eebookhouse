package com.eebookhouse.servlet.manage.order;

import com.eebookhouse.entity.Book;
import com.eebookhouse.entity.Order;
import com.eebookhouse.entity.Remark;
import com.eebookhouse.entity.User;
import com.eebookhouse.service.BookService;
import com.eebookhouse.service.Impl.BookServiceImpl;
import com.eebookhouse.service.Impl.OrderServiceImpl;
import com.eebookhouse.service.OrderService;
import com.eebookhouse.utils.DateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@WebServlet("/order/add")
public class AddOrderServlet extends HttpServlet {

    private OrderService orderService;
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        orderService = new OrderServiceImpl();
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer book_id = Integer.parseInt(req.getParameter("book_id"));
        User user = (User)req.getSession().getAttribute("user");
        String buy_num_str = req.getParameter("buy_num");
        Integer number = 1;
        if(!buy_num_str.equals(""))
            number = Integer.parseInt(buy_num_str);
        String date = DateUtil.dateToString(new Date());
        if(user != null){
            Order order = new Order();
            order.setBook(bookService.getBookById(book_id));
            order.setUser((User)req.getSession().getAttribute("user"));
            order.setNumber(number);
            order.setAddress(user.getAddress());
            order.setPostcode(user.getPostcode());
            order.setOrderdate(date);
            order.setStatus(Order.STATUS_UNCHECKED);
            if(!orderService.addOrder(order)){
                req.getSession().setAttribute("order-add-failure", new Object());
            }
        }else{
            req.getSession().setAttribute("order-add-failure", new Object());
        }
        resp.sendRedirect("/eebookhouse/order");
    }
}
