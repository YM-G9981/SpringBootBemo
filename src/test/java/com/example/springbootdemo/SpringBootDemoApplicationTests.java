package com.example.springbootdemo;

import com.example.springbootdemo.mapper.StudentMapper;
import com.example.springbootdemo.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootDemoApplicationTests {
     @Autowired
    BCryptPasswordEncoder by;
     @Resource
     UserMapper userMapper;
    @Test
    void main(){
        String s = "123";
        String encode = by.encode(s);
        String encode2 = by.encode(s);
        String admin = userMapper.findUserByName("09").getPassword();
        System.out.println(by.matches(s,encode2));
        System.out.println(encode);
        System.out.println(encode2);
    }

    @Resource
    StudentMapper studentMapper;
    @Test
     void main2() throws JsonProcessingException {
//        List<StudentAddEclass> studrntaddEclasses = studentMapper.FindAllStudentByClass("1908001");
//        studrntaddEclasses.forEach(a-> System.out.println(a));

    }
}
