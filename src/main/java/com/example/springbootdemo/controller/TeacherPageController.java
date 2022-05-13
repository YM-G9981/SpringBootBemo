package com.example.springbootdemo.controller;

import com.example.springbootdemo.dao.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TeacherPageController {
    String TeacherOption(String option, HttpServletRequest request, HttpServletResponse response, Model model);

    String SelectStudent(String type, String value, HttpServletRequest request, HttpServletResponse response, Model model);

    String InsertNewStudent(Student student, HttpServletRequest request, HttpServletResponse response, Model model);

    String ModifyStudent(String modifyid, Student modifystu, HttpServletRequest request, HttpServletResponse response, Model model);

    String ModifyOption(String stu, HttpServletRequest request, HttpServletResponse response, Model model) throws JsonProcessingException;
}