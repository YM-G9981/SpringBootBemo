package com.example.springbootdemo.mapper;

import com.example.springbootdemo.dao.UserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResignMapper {
    @Insert("insert into users (username,password,role) values (#{username},#{password},#{role})")
    int InsertUser(UserData userData);
}