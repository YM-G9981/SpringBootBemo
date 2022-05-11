package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.UserData;
import com.example.springbootdemo.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserAuthService implements UserDetailsService {
    @Resource
    UserMapper userMapper;
    @Resource
    HttpServletResponse httpServletResponse;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserData user = userMapper.findUserByName(username);
        if(user==null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        return User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
