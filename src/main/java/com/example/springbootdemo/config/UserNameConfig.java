package com.example.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
@Configuration
public class UserNameConfig {
    public String getusername() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return username;
    }
}
