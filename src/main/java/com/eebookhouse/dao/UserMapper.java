package com.eebookhouse.dao;

import com.eebookhouse.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("SELECT * FROM userinfo WHERE username=#{username} and userpass=#{userpass}")
    User getUser(@Param("username")String username, @Param("userpass")String userpass);

    @Select("SELECT * FROM userinfo WHERE id=#{id}")
    User getUserById(@Param("id")Integer id);

    @Select("SELECT count(*) FROM userinfo WHERE email=#{email}")
    Integer checkUserEmail(@Param("email")String email);

    @Select("SELECT count(*) FROM userinfo WHERE username=#{username}")
    Integer isExistUser(@Param("username")String username);

    @Insert("INSERT INTO userinfo VALUES (NULL,#{username},#{userpass},NULL,NULL,NULL,0,0)")
    Integer registerUser(@Param("username")String username, @Param("userpass")String userpass);

    @Update("UPDATE userinfo SET username=#{username},userpass=#{userpass},email=#{email},address=#{address},postcode=#{postcode},level=#{level},power=#{power} WHERE id=#{id}")
    Integer updateUser(@Param("id") Integer id,
                       @Param("username") String username,
                       @Param("userpass") String userpass,
                       @Param("email") String email,
                       @Param("address") String address,
                       @Param("postcode") String postcode,
                       @Param("level") Integer level,
                       @Param("power") Integer power
    );
}
