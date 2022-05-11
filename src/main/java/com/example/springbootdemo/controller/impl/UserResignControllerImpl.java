package com.example.springbootdemo.controller.impl;

import com.example.springbootdemo.controller.UserResignController;
import com.example.springbootdemo.dao.UserData;
import com.example.springbootdemo.mapper.ResignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserResignControllerImpl implements UserResignController {
    @Autowired
    ResignMapper resignMapper;
    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;
    @PostMapping("/resignUser")
    @Override
    public void Assess(String username , String password, String role, HttpServletResponse response,HttpServletRequest request) throws Exception{
        password = bcryptPasswordEncoder.encode(password);
        try {
            resignMapper.InsertUser(new UserData(username, password, role));
        }catch (Exception e){
           request.getRequestDispatcher("/resignFailure").forward(request,response);
        }
        request.getRequestDispatcher("/resignSuccess").forward(request,response);
    }
}
