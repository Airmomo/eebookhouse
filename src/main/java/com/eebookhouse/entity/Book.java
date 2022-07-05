package com.eebookhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
public class Book {
    Integer id;
    String bookname;
    String type;
    String isbn;
    String writer;
    String publisher;
    String intro;
    Double price;
    Integer remaining;
    String picture;
    String date;
}
