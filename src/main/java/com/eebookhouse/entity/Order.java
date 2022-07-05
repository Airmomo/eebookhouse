package com.eebookhouse.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    public static final int STATUS_UNCHECKED = 0;
    public static final int STATUS_CHECKED = 1;

    Integer id;
    Book book;
    User user;
    Integer number;
    String address;
    String postcode;
    String orderdate;
    Integer status;
}
