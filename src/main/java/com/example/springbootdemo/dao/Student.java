package com.example.springbootdemo.dao;

import lombok.Data;
@Data
public class Student extends User {
    private String StudentID;
    private String EClassid;
}