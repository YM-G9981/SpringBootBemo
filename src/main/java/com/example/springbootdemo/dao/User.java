package com.example.springbootdemo.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String UserName;
    private String Name;
    private String Address;
    private Integer Age;
    private String Gendle;
}
