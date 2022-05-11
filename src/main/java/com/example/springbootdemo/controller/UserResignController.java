package com.example.springbootdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserResignController {
    void Assess(String username, String password, String role, HttpServletResponse response, HttpServletRequest request) throws Exception;
}
