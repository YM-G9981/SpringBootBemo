package com.example.springbootdemo.dao;

import lombok.Data;

import java.util.List;

@Data
public class Teacher extends User{
    private List<String> eClasses;
    private String TeacherID;
}
