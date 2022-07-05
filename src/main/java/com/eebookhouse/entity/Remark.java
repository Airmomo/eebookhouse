package com.eebookhouse.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Remark {
    Integer id;
    Book book;
    User user;
    Integer grade;
    String remark;
    String date;
}
