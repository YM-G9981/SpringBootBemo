package com.example.springbootdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ResignController {
    String resign(HttpServletResponse response, HttpServletRequest request);
    String ResignSuccess(HttpServletResponse response, HttpServletRequest request);
    String ResignFailure(HttpServletResponse response, HttpServletRequest request);
}
