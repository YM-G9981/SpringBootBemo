package com.example.springbootdemo.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student extends User implements Serializable {
    private String StudentID;
    private String EClassid;
}