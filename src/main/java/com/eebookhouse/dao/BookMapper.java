package com.eebookhouse.dao;

import com.eebookhouse.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface BookMapper {

    @Select("SELECT * FROM bookinfo")
    List<Book> getBookList();

    @Select("SELECT * FROM bookinfo WHERE id=#{id}")
    Book getBookById(@Param("id") Integer id);

    @Select("SELECT * FROM bookinfo WHERE bookname=#{name}")
    Book getBookByName(@Param("name") String name);

    @Insert("INSERT INTO bookinfo VALUES (NULL,#{bookname},#{type},#{isbn},#{writer},#{publisher},#{intro},#{price},#{remaining},#{picture},#{date})")
    Integer addBook(@Param("bookname") String bookname,
                        @Param("type") String type,
                        @Param("isbn") String isbn,
                        @Param("writer") String writer,
                        @Param("publisher") String publisher,
                        @Param("intro") String intro,
                        @Param("price") Double price,
                        @Param("remaining") Integer remaining,
                        @Param("picture") String picture,
                        @Param("date") String date);

    @Delete("DELETE FROM bookinfo WHERE id=#{id}")
    Integer deleteBook(@Param("id") Integer id);

    @Update("UPDATE bookinfo SET bookname=#{bookname},type=#{type},isbn=#{isbn},writer=#{writer},publisher=#{publisher},intro=#{intro},price=#{price},remaining=#{remaining},picture=#{picture},date=#{date} WHERE id=#{id}")
    Integer updateBook(@Param("id") Integer id,
                           @Param("bookname") String bookname,
                           @Param("type") String type,
                           @Param("isbn") String isbn,
                           @Param("writer") String writer,
                           @Param("publisher") String publisher,
                           @Param("intro") String intro,
                           @Param("price") Double price,
                           @Param("remaining") Integer remaining,
                           @Param("picture") String picture,
                           @Param("date") String date);

}
