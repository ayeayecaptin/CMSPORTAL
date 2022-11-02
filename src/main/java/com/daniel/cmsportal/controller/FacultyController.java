package com.daniel.cmsportal.controller;

import com.daniel.cmsportal.Repository.FacultyReository;
import com.daniel.cmsportal.model.Faculty;
import com.daniel.cmsportal.model.User;
import com.daniel.cmsportal.model.UserDTO;
import com.daniel.cmsportal.model.enumeration.FacultyRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyReository facultyReository;



    @PostMapping("/formlist")
    public String addUpdateFaculty(Faculty faculty, HttpServletRequest request)
    {
        facultyReository.save(faculty);
        return "redirect:"+ request.getHeader("Referer");
    }

    @GetMapping("/formlist")
    public String create(Model model, @RequestParam(required = false) Long id)
    {

        model.addAttribute("facultyroles", FacultyRole.values());

        model.addAttribute("faculties",facultyReository.findAll());
        if(id == null)
        {
            model.addAttribute("faculty",new Faculty());
        }else{
            model.addAttribute("faculty", facultyReository.findById(id).orElse(new Faculty()));
        }
        return "/faculty/formlist";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam(required = true) Long id)
    {
         facultyReository.deleteById(id);
        return "redirect:/faculty/formlist";
    }

}
