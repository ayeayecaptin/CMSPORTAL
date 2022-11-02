package com.daniel.cmsportal.controller;


import com.daniel.cmsportal.Repository.ClassroomRepository;
import com.daniel.cmsportal.Repository.FacultyReository;
import com.daniel.cmsportal.Repository.StudentRepository;
import com.daniel.cmsportal.Service.ClassRoomService;
import com.daniel.cmsportal.model.*;

import com.daniel.cmsportal.model.enumeration.Room;
import com.daniel.cmsportal.model.enumeration.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private FacultyReository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRoomService classRoomService;

    @PostMapping("/formlist")
    public String addUpdateClassroom(ClassRoomDTO classroomdto, HttpServletRequest request)
    {
        classRoomService.save(classroomdto);
        return "redirect:"+ request.getHeader("Referer");
    }

    @GetMapping("/formlist")
    public String create(Model model, @RequestParam(required = false) Long id)
    {

        model.addAttribute("rooms", Room.values());
        model.addAttribute("semesters", Semester.values());
        model.addAttribute("faculties", facultyRepository.findAll());
        model.addAttribute("classrooms",classroomRepository.findAll());
        model.addAttribute("students",studentRepository.findAll());
        if(id == null)
        {
            model.addAttribute("classroomdto",new ClassRoomDTO());
        }else{
            model.addAttribute("classroomdto", new ClassRoomDTO(classroomRepository.findById(id).orElse(new ClassRoom())));
        }
        return "/classroom/formlist";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam(required = true) Long id)
    {
        classroomRepository.deleteById(id);
        return "redirect:/classroom/formlist";
    }

    @GetMapping("/removestudent")
    public String removestudent(@RequestParam(required = true, name = "studentid") Long studentid, @RequestParam(required = true, name = "classroomid") Long classroomid)
    {


        Student student  = studentRepository.findById(studentid).orElse(null);
        ClassRoom clasroom = classroomRepository.findById(classroomid).orElse(null);


        if(student != null && clasroom != null)
        {
            classRoomService.deleteStudent(student, clasroom);


        }
        return "redirect:/classroom/formlist?id=" + classroomid;
    }
}
