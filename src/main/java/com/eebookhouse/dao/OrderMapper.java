package com.eebookhouse.dao;

import com.eebookhouse.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface OrderMapper {

    @Select("SELECT * FROM orders")
    @Results(id = "order_map",value = {
            @Result(id = true,column = "id", property = "id"),
            @Result(
                    column = "bookid",
                    property = "book",
                    one = @One(select = "com.eebookhouse.dao.BookMapper.getBookById")
            ),
            @Result(
                    column = "userid",
                    property = "user",
                    one = @One(select = "com.eebookhouse.dao.UserMapper.getUserById")
            ),
            @Result(column = "address",property = "address"),
            @Result(column = "postcode",property = "postcode"),
            @Result(column = "orderdate",property = "orderdate"),
            @Result(column = "status",property = "status")
    })
    List<Order> getOrderList();

    @Select("SELECT * FROM orders WHERE id=#{id}")
    @ResultMap("order_map")
    Order getOrderById(@Param("id")Integer id);

    @Insert("INSERT INTO orders VALUES (NULL,#{book_id},#{user_id},#{number},#{address},#{postcode},#{orderdate},#{status})")
    Integer addOrder(@Param("book_id")Integer book_id,
                     @Param("user_id")Integer user_id,
                     @Param("number") Integer number,
                     @Param("address") String address,
                     @Param("postcode") String postcode,
                     @Param("orderdate") String orderdate,
                     @Param("status")Integer status);

    @Delete("DELETE FROM orders WHERE id=#{id}")
    Integer deleteOrder(@Param("id")Integer id);

    @Update("UPDATE orders SET bookid=#{book_id},userid=#{user_id},number=#{number},address=#{address},postcode=#{postcode},orderdate=#{orderdate},status=#{status} WHERE id=#{id}")
    Integer updateOrder(@Param("id")Integer id,
                     @Param("book_id")Integer book_id,
                     @Param("user_id")Integer user_id,
                     @Param("number") Integer number,
                     @Param("address") String address,
                     @Param("postcode") String postcode,
                     @Param("orderdate") String orderdate,
                     @Param("status")Integer status);

}
