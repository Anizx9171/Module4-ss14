package com.ss13.controller;

import com.ss13.model.entity.Student;
import com.ss13.model.service.student.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.Path;

@Controller
public class NavigateController {
    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping("/")
    public String goHome(){
        return "index";
    }

    @RequestMapping("/table-student")
    public String gotable(Model model){
        model.addAttribute("students", studentService.findAll());
        return "studentTable";
    }

    @RequestMapping("/add")
    public String goFormAdd(Model model){
        model.addAttribute("student", new Student());
        return "formAdd";
    }

    @RequestMapping("/add-comfim")
    public String addComfim(@ModelAttribute("student") Student student, Model model){
        studentService.add(student);
        return gotable(model);
    }

    @RequestMapping("/edit/{id}")
    public String goFormEdit(Model model, @PathVariable("id") int id){
        model.addAttribute("studentU", studentService.findById(id));
        return "formUpdate";
    }

    @RequestMapping("/edit-comfim")
    public String editComfim(@ModelAttribute("studentU") Student student, Model model){
        studentService.update(student);
        return gotable(model);
    }

    @RequestMapping("/delete/{id}")
    public String goFormDelete(@PathVariable("id") int id, Model model){
        studentService.remove(id);
        return gotable(model);
    }
}