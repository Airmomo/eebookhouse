package com.eebookhouse.dao;

import com.eebookhouse.entity.Book;
import com.eebookhouse.entity.Remark;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface RemarkMapper {

    @Select("SELECT * FROM remark")
    @Results(id = "remark_map",value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(
                    column = "bookid",//根据那个字段去查询user表的数据
                    property = "book",//要封装的属性名称
                    one = @One(select = "com.eebookhouse.dao.BookMapper.getBookById")
            ),
            @Result(
                    column = "userid",
                    property = "user",
                    one = @One(select = "com.eebookhouse.dao.UserMapper.getUserById")
            ),
            @Result(column = "grade", property = "grade"),
            @Result(column = "remark", property = "remark"),
            @Result(column = "date", property = "date"),
    })
    List<Remark> getRemarkList();

    @Select("SELECT * FROM remark WHERE id=#{id}")
    @ResultMap("remark_map")
    Remark getRemarkById(@Param("id")Integer id);

    @Insert("INSERT INTO remark VALUES (NULL,#{bookid},#{userid},#{grade},#{remark},#{date})")
    Integer addRemark(@Param("bookid") Integer bookid,
                        @Param("userid") Integer userid,
                        @Param("grade") Integer grade,
                        @Param("remark") String remark,
                        @Param("date") String date);

    @Delete("DELETE FROM remark WHERE id=#{id}")
    Integer deleteRemark(@Param("id")Integer id);

    @Update("UPDATE remark SET bookid=#{book_id},userid=#{user_id},grade=#{grade},remark=#{remark},date=#{date} WHERE id=#{id}")
    Integer updateRemark(@Param("id")Integer id,
                         @Param("bookid") Integer bookid,
                         @Param("userid") Integer userid,
                         @Param("grade") Integer grade,
                         @Param("remark") String remark,
                         @Param("date") String date);

}
