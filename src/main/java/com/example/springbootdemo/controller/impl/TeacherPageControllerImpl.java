package com.example.springbootdemo.controller.impl;

import com.example.springbootdemo.config.UserNameConfig;
import com.example.springbootdemo.controller.BaseController;
import com.example.springbootdemo.controller.TeacherPageController;
import com.example.springbootdemo.dao.*;
import com.example.springbootdemo.mapper.StudentMapper;
import com.example.springbootdemo.mapper.TeacherMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/TeacherOption")
public class TeacherPageControllerImpl implements TeacherPageController { //
    @Resource
    StudentMapper studentMapper;
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    UserNameConfig userNameConfig;
    @Resource
    BaseController baseController;
    @Resource
    ObjectMapper objectMapper;
    @Override
    @RequestMapping("/Option")
    public String TeacherOption(String option,HttpServletRequest request,HttpServletResponse response,Model model){
        String username = userNameConfig.getusername();
        Teacher teacher = findTeacherByUserName(username,request);
        switch (option){
            case "selectAllStudent":{
                List<String> eClasses = teacher.getEClasses();
                List<StudentAddEclass> students = new ArrayList<>();
                for(String e:eClasses) {
                    students.addAll(studentMapper.FindAllStudentByClass(e));
                }

                model.addAttribute("stus",students);
                break;
            }
            case "selectStudent":{
                model.addAttribute("selectbool",true);
                break;
            }
            case "inputStudent":{
                model.addAttribute("newstu",new Student());
                List<eClass> eclasses = findEClassByTeacher(teacher);
                model.addAttribute("eclasses",eclasses);
                break;
            }
            case "modifyStudent":{
                model.addAttribute("modifybool",true);
                break;
            }
            default:
                break;
        }
        return baseController.success_login(response,request,model);
    }

    @Override
    @RequestMapping("/Select/SelectStudent")
    public String SelectStudent(String type,String value,HttpServletRequest request,HttpServletResponse response,Model model){
        List<StudentAddEclass> students = studentMapper.FindStudentByElement(type, value);
        model.addAttribute("stus",students);
        return baseController.success_login(response,request,model);
    }

    @Override
    @PostMapping("/Insert/InsertNewStudent")
    public String InsertNewStudent(@ModelAttribute Student newstu, HttpServletRequest request, HttpServletResponse response, Model model){
        try {
            studentMapper.InsertNewStudent(newstu);
        } catch (Exception e){
            return "/TeacherPage/InsertStuDent/Failure";
        }
        return "/TeacherPage/InsertStuDent/Success";
    }
    @RequestMapping("/Modify/ModifyStudent")
    @Override
    public String ModifyStudent(StudentAddEclass modifystu, HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            studentMapper.DeleteStudentById(modifystu.getStudentID());
            studentMapper.InsertNewStudent(modifystu);
        }catch (Exception e){
            return "/TeacherPage/DeleteStuDent/Failure";
        }
        return "/TeacherPage/DeleteStuDent/Success";
    }

    @RequestMapping("/Modify")
    @Override
    public String ModifyOption( String stu, HttpServletRequest request, HttpServletResponse response,Model model) throws JsonProcessingException {
        StudentAddEclass student = objectMapper.readValue(stu, StudentAddEclass.class);
        String username = userNameConfig.getusername();
        Teacher teacher = findTeacherByUserName(username,request);
        List<eClass> classes = findEClassByTeacher(teacher);
        model.addAttribute("eclasses",classes);
        model.addAttribute("modifystu",student);
        return baseController.success_login(response,request,model);
    }

    private List<eClass> findEClassByTeacher(Teacher teacher){
        List<String> classes = teacher.getEClasses();
        List <eClass> eclasses = new ArrayList<>();
        for (String classid:classes) {
            eclasses.add(teacherMapper.FindClassesByEclassID(classid));
        }
        return eclasses;
    }
    private Teacher findTeacherByUserName(String username, HttpServletRequest request){
        Object tea = request.getSession().getAttribute(username);
        Teacher teacher = null;
        if(tea instanceof Teacher)
            teacher = (Teacher) tea;
        return teacher;
    }
}
