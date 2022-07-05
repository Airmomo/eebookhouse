package com.eebookhouse.service.Impl;

import com.eebookhouse.dao.OrderMapper;
import com.eebookhouse.dao.RemarkMapper;
import com.eebookhouse.entity.Order;
import com.eebookhouse.entity.Remark;
import com.eebookhouse.service.OrderService;
import com.eebookhouse.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> getOrderList() {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            return mapper.getOrderList();
        }
    }

    @Override
    public List<Order> getOrderListByUserId(Integer userId) {
        return this.getOrderList()
                .stream()
                .filter(order -> order.getUser().getId().intValue() == userId)
                .collect(Collectors.toList());
    }



    @Override
    public Order getOrder(Integer id) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            return mapper.getOrderById(id);
        }
    }

    @Override
    public boolean updateOrder(Order order) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            int row = mapper.updateOrder(order.getId(),
                    order.getBook().getId(),
                    order.getUser().getId(),
                    order.getNumber(),
                    order.getAddress(),
                    order.getPostcode(),
                    order.getOrderdate(),
                    order.getStatus()
            );
            return row > 0;
        }
    }

    @Override
    public boolean addOrder(Order order) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            int row = mapper.addOrder(
                    order.getBook().getId(),
                    order.getUser().getId(),
                    order.getNumber(),
                    order.getAddress(),
                    order.getPostcode(),
                    order.getOrderdate(),
                    order.getStatus()
            );
            return row > 0;
        }
    }

    @Override
    public boolean checkedOrder(Integer id) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            Order order = this.getOrder(id);
            order.setStatus(Order.STATUS_CHECKED);
            int row = mapper.updateOrder(order.getId(),
                    order.getBook().getId(),
                    order.getUser().getId(),
                    order.getNumber(),
                    order.getAddress(),
                    order.getPostcode(),
                    order.getOrderdate(),
                    order.getStatus()
            );
            return row > 0;
        }
    }

    @Override
    public boolean deleteOrderById(Integer id) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            int row = mapper.deleteOrder(id);
            return row > 0;
        }
    }
}
