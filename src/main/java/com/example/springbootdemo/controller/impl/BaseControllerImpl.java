package com.example.springbootdemo.controller.impl;

import com.example.springbootdemo.config.UserNameConfig;
import com.example.springbootdemo.controller.BaseController;
import com.example.springbootdemo.dao.Student;
import com.example.springbootdemo.dao.Teacher;
import com.example.springbootdemo.dao.UserData;
import com.example.springbootdemo.mapper.StudentMapper;
import com.example.springbootdemo.mapper.TeacherMapper;
import com.example.springbootdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class BaseControllerImpl implements BaseController {
    @Resource
    StudentMapper studentMapper;
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    UserNameConfig userNameConfig;
    @RequestMapping("/")
    @Override
    public  String asscss(HttpServletResponse response, HttpServletRequest request) {
      return "/LoginPage/login";
    }
    @RequestMapping("/main")
    @Override
    public  String success_login(HttpServletResponse response, HttpServletRequest request, Model model) {
        String username = userNameConfig.getusername();
        UserData ud = userMapper.findUserByName(username);
        model.addAttribute("user",ud);
        model.addAttribute("modifybool",false);
        if(ud.getRole().equals("student")){
            Student student = studentMapper.FindAllStudentByUsername(username);
            request.getSession().setAttribute(username,student);
            return "/MainPage/StuMain";
        }

        else{
            Teacher teacher = teacherMapper.FindTeacherByUserName(username);
            model.addAttribute("teacheruser",teacher);
            request.getSession().setAttribute(username,teacher);

            return "/MainPage/TeacherMain";
        }

    }

    @RequestMapping("/failure")
    @Override
    public  String failure(HttpServletResponse response, HttpServletRequest request) {
        return "/LoginPage/failure";
    }
}
