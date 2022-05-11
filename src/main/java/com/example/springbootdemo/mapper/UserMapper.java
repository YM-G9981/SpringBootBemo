package com.example.springbootdemo.mapper;

import com.example.springbootdemo.dao.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper  {
    @Select("select * from users where username = #{username}")
    UserData findUserByName(String username);
}
