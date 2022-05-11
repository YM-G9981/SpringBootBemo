package com.example.springbootdemo.dao;

import lombok.Data;

@Data
public class UserData {
private String Username;
private String Password;
private String Role;

    public UserData(String username, String password, String role) {
        Username = username;
        Password = password;
        Role = role;
    }
}
