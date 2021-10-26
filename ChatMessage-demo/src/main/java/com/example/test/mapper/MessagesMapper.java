package com.example.test.mapper;

import com.example.test.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessagesMapper {
    @Select("select * from MESSAGES where usernmae=#{username}")

    List<ChatMessage> findByName(String username);

    @Insert("insert into MESSAGES(username,messagetext) values(#{usrename},#{messageText})" )
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int addMessage(ChatMessage chatMessage);
}
