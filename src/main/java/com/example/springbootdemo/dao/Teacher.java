package com.example.springbootdemo.dao;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Teacher extends User implements Serializable {
    private List<String> eClasses;
    private String TeacherID;
}
