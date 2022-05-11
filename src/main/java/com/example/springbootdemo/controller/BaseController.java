package com.example.springbootdemo.controller;

import com.example.springbootdemo.dao.UserData;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseController {
    String asscss(HttpServletResponse response, HttpServletRequest request);

    String success_login(HttpServletResponse response, HttpServletRequest request, Model model);

    String failure(HttpServletResponse response, HttpServletRequest request);
}
