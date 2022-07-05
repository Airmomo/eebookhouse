package com.eebookhouse.service;

import com.eebookhouse.entity.Book;
import com.eebookhouse.entity.Order;

import java.util.List;

public interface BookService {
    List<Book> getBookList();
    List<Book> getBookListByType(String type);
    List<Book> getBookListBySearch(String condition);
    Book getBookById(Integer id);
    Book getBookByName(String name);

    boolean addBook(Book book);
    boolean deleteBookById(Integer id);
    boolean updateBook(Book book);

    boolean subBookRemaining(Integer book_id,Integer order_id);
    boolean addBookRemaining(Integer book_id,Integer order_id);
}
