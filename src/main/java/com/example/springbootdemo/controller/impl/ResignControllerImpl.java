package com.example.springbootdemo.controller.impl;

import com.example.springbootdemo.controller.ResignController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResignControllerImpl implements ResignController {
    @RequestMapping("/resign")
    @Override
    public  String resign(HttpServletResponse response, HttpServletRequest request) {
        return "ResignPages/resign";
    }
    @RequestMapping("/resignSuccess")
    @Override
    public  String ResignSuccess(HttpServletResponse response, HttpServletRequest request) {
        return "ResignPages/ResignSuccess";
    }
    @RequestMapping("/resignFailure")
    @Override
    public  String ResignFailure(HttpServletResponse response, HttpServletRequest request) {
        return "ResignPages/ResignFailure";
    }
}
