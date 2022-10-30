package com.daniel.cmsportal.controller;


import com.daniel.cmsportal.Service.StudentService;
import com.daniel.cmsportal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private com.daniel.cmsportal.Repository.StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String getAll(Model model)
    {
            List<Student> students = studentRepository.findAll();
            model.addAttribute("students", students);

        return "/student/student";
    }


    @GetMapping("/detail")
    public String detail(Model model, @RequestParam(required = false) Long id)
    {
        if(id == null)
        {
            model.addAttribute("student", new Student());
        }
        else
        {
            Student st = studentRepository.findById(id).orElse(null);
            model.addAttribute("student", st);
        }
        return "/student/detail";
    }

    @PostMapping("/detail")
    public String newStudent(Student student)
    {
         studentService.save(student);
         return "redirect:/student/student ";
    }
}
