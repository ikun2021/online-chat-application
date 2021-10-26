package com.example.test.mapper;

import com.example.test.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from USERS where username=#{username}")
    User findByName(String username);

    @Insert("insert into USERS(username,salt,password,firstname,lastname) values(#{username},#{salt},#{password},#{firstName},#{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int insert(User user);
}
