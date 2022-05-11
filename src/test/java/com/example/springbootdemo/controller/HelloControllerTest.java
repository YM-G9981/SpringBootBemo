package com.example.springbootdemo.controller;

import com.example.springbootdemo.dao.StudentAddEclass;
import com.example.springbootdemo.mapper.StudentMapper;
import com.example.springbootdemo.mapper.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@SpringBootTest
class HelloControllerTest {
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    TeacherPageController teacherPageController;
    @Resource
    HttpServletRequest request;
    @Resource
    HttpServletResponse response;
    @Resource
    Model model;
    @Resource
    StudentMapper studentMapper;
    @Test
    public void main(){
        List<StudentAddEclass> studrntaddEclasses = studentMapper.FindAllStudentByClass("1908001");
        studrntaddEclasses.forEach(a-> System.out.println(a));
    }
}