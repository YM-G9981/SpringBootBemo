package com.example.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Configuration
public class UserNameConfig {
    @Resource
    HttpServletRequest request;
    public String getusername() {
        Cookie[] cookies = request.getCookies();
        String username = null;
        for (Cookie cook:cookies) {
            if (cook.getName().equals("DemoUsername"))
                username = cook.getValue();
        }
        return username;
    }
}
