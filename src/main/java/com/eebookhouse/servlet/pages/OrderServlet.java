package com.eebookhouse.servlet.pages;

import com.eebookhouse.entity.Book;
import com.eebookhouse.entity.Order;
import com.eebookhouse.entity.Remark;
import com.eebookhouse.entity.User;
import com.eebookhouse.service.Impl.OrderServiceImpl;
import com.eebookhouse.service.Impl.RemarkServiceImpl;
import com.eebookhouse.service.OrderService;
import com.eebookhouse.service.RemarkService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private OrderService service;

    @Override
    public void init() throws ServletException {
        service = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        Integer user_id = user.getId();
        if(user_id != null && user_id != 0){
            List<Order> list = service.getOrderListByUserId(user_id);
            List<Order> list_unchecked = list.stream()
                    .filter(order -> order.getStatus() == Order.STATUS_UNCHECKED)
                    .collect(Collectors.toList());
            List<Order> list_checked = list.stream()
                    .filter(order -> order.getStatus() == Order.STATUS_CHECKED)
                    .collect(Collectors.toList());
            req.setAttribute("order_list_unchecked",list_unchecked);
            req.setAttribute("order_list_checked",list_checked);
        }
        if (req.getSession().getAttribute("order-add-failure") != null) {
            req.setAttribute("order-add-failure", true);
            req.getSession().removeAttribute("order-add-failure");
        }
        if (req.getSession().getAttribute("order-delete-failure") != null) {
            req.setAttribute("order-delete-failure", true);
            req.getSession().removeAttribute("order-delete-failure");
        }
        if (req.getSession().getAttribute("order-check-failure") != null) {
            req.setAttribute("order-check-failure", true);
            req.getSession().removeAttribute("order-check-failure");
        }
        req.getRequestDispatcher("/car-order.jsp").forward(req,resp);
    }

}
