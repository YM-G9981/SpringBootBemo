package com.example.springbootdemo.mapper;

import com.example.springbootdemo.dao.Teacher;
import com.example.springbootdemo.dao.eClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select * from teachers where username = #{username}")
    @Results({
            @Result(id = true, column =  "TeacherID",property = "TeacherID"),
            @Result(column =  "UserName",property = "UserName"),
            @Result(column =  "Name",property = "Name"),
            @Result(column =  "Address",property = "Address"),
            @Result(column =  "Age",property = "Age"),
            @Result(column = "Gendle",property = "Gendle"),
            @Result(column = "teacherid",property = "eClasses",many = @Many(select = "com.example.springbootdemo.mapper.TeacherMapper.FindClassesByTeacherID"))
            }
    )
    Teacher FindTeacherByUserName(String username);
    @Select("select eclasses.ideclass from teachertoeclasses,eclasses where teacherid = #{TeacherID} and teachertoeclasses.eclassesid= eclasses.ideclass")
    List<String> FindClassesByTeacherID(String TeacherID);
    @Select("select * from eclasses where ideclass = #{EClassID} ")
    eClass FindClassesByEclassID(String EClassID);

}
