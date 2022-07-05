package com.eebookhouse.service.Impl;

import com.eebookhouse.dao.BookMapper;
import com.eebookhouse.entity.Book;
import com.eebookhouse.service.BookService;
import com.eebookhouse.utils.DateUtil;
import com.eebookhouse.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getBookList() {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            return mapper.getBookList();
        }
    }

    @Override
    public List<Book> getBookListByType(String type) {
        return this.getBookList()
                .stream()
                .filter(book -> book.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBookListBySearch(String condition) {
        return this.getBookList()
                .stream()
                .filter(book -> book.getBookname().contains(condition))
                .collect(Collectors.toList());
    }

    @Override
    public Book getBookById(Integer id) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            Book book = mapper.getBookById(id);
            return book;
        }
    }

    @Override
    public Book getBookByName(String name) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            Book book = mapper.getBookByName(name);
            return book;
        }
    }

    @Override
    public boolean addBook(Book book) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            int row = mapper.addBook(book.getBookname(),
                    book.getType(),
                    book.getIsbn(),
                    book.getWriter(),
                    book.getPublisher(),
                    book.getIntro(),
                    book.getPrice(),
                    book.getRemaining(),
                    book.getPicture(),
                    DateUtil.dateToString(new Date()));
            return row > 0;
        }
    }

    @Override
    public boolean deleteBookById(Integer id) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            int row = mapper.deleteBook(id);
            return row > 0;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            int row = mapper.updateBook(book.getId(),
                    book.getBookname(),
                    book.getType(),
                    book.getIsbn(),
                    book.getWriter(),
                    book.getPublisher(),
                    book.getIntro(),
                    book.getPrice(),
                    book.getRemaining(),
                    book.getPicture(),
                    book.getDate());
            return row > 0;
        }
    }

    @Override
    public boolean subBookRemaining(Integer book_id,Integer number) {
        Book book = this.getBookById(book_id);
        book.setRemaining(book.getRemaining() - number);
        return this.updateBook(book);
    }

    @Override
    public boolean addBookRemaining(Integer book_id,Integer number) {
        Book book = this.getBookById(book_id);
        book.setRemaining(book.getRemaining() + number);
        return this.updateBook(book);
    }
}
