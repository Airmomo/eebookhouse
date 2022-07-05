package com.eebookhouse.service;

import com.eebookhouse.entity.Order;
import com.oracle.wls.shaded.org.apache.xpath.operations.Or;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();
    List<Order> getOrderListByUserId(Integer user_id);
    Order getOrder(Integer id);
    boolean updateOrder(Order order);
    boolean addOrder(Order order);
    boolean checkedOrder(Integer id);
    boolean deleteOrderById(Integer id);
}
