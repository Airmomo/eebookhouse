package com.eebookhouse.servlet.manage.order;

import com.eebookhouse.service.Impl.OrderServiceImpl;
import com.eebookhouse.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/order/checked")
public class CheckedOrderServlet extends HttpServlet {

    private OrderService service;

    @Override
    public void init() throws ServletException {
        service = new OrderServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] order_ids = req.getParameterValues("order_id");
        if(order_ids != null && order_ids.length != 0){
            int[] order_list = Arrays.stream(order_ids)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.stream(order_list).forEach(order_id -> service.checkedOrder(order_id));
        }
        resp.sendRedirect("/eebookhouse/thanks.jsp");
    }
}
