package com.example.springbootdemo.mapper;

import com.example.springbootdemo.dao.Student;
import com.example.springbootdemo.dao.StudentAddEclass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from students where eclassid = #{eclassID}")
    @Results({
            @Result(id = true, column =  "StudentID",property = "StudentID"),
            @Result(column =  "UserName",property = "UserName"),
            @Result(column =  "Name",property = "Name"),
            @Result(column =  "Address",property = "Address"),
            @Result(column =  "Age",property = "Age"),
            @Result(column = "Gendle",property = "Gendle"),
            @Result(column = "eclassid",property = "EClassName",one = @One (select = "com.example.springbootdemo.mapper.StudentMapper.FindClassesByeClassId"))
    })
    List<StudentAddEclass> FindAllStudentByClass(String eclassID);
    @Select("select * from students where username = #{username}")
    Student FindAllStudentByUsername(String username);

    @Select("select * from students where ${type} = #{value}")
    @Results({
            @Result(id = true, column =  "StudentID",property = "StudentID"),
            @Result(column =  "UserName",property = "UserName"),
            @Result(column =  "Name",property = "Name"),
            @Result(column =  "Address",property = "Address"),
            @Result(column =  "Age",property = "Age"),
            @Result(column = "Gendle",property = "Gendle"),
            @Result(column = "eclassid",property = "EClassName",one = @One (select = "com.example.springbootdemo.mapper.StudentMapper.FindClassesByeClassId"))
    })
    List<StudentAddEclass> FindStudentByElement(String type, String value);

    @Insert("insert into students (Name,Address,Age,Gendle,StudentID,eClassid,username)" +
            " values (#{Name},#{Address},#{Age},#{Gendle},#{StudentID},#{EClassid},#{UserName})")
    int InsertNewStudent(Student newstudent);

    @Select("select eclassname from eclasses where ideclass = #{eclassid}")
    String FindClassesByeClassId(String eclassid);

    @Delete("delete from students where studentid = #{studentid}")
    int DeleteStudentById(String studentid);
}
