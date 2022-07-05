package com.eebookhouse.servlet.manage.order;

import com.eebookhouse.service.Impl.OrderServiceImpl;
import com.eebookhouse.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/order/delete")
public class DeleteOrderServlet extends HttpServlet {

    private OrderService service;

    @Override
    public void init() throws ServletException {
        service = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int order_id = Integer.parseInt(req.getParameter("order_id"));
        if(order_id != 0){
            if(!service.deleteOrderById(order_id)){
                req.getSession().setAttribute("order-delete-failure", new Object());
            }
        }
        resp.sendRedirect("/eebookhouse/order");
    }

}
