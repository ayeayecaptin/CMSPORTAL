package com.daniel.cmsportal.controller;

import com.daniel.cmsportal.Repository.UserRepository;
import com.daniel.cmsportal.Service.UserService;
import com.daniel.cmsportal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getAll(Model model)
    {
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);

        return "/user/list";
    }



    @GetMapping("/formlist")
    public String getAllForm(Model model)
    {

        List<User> users = userRepository.findAll();

        model.addAttribute("users",users);
        model.addAttribute("auser", new User());


        return "/user/formlist";
    }


    @PostMapping("/detail")
    public String addUser(User user)
    {
        userService.save(user);
        return "redirect:/user/formlist";
    }

    @PostMapping("/delete")
    public String del(@RequestParam(required = true) Long id,  User user)
    {
        userService.save(user);
        return "redirect:/user/formlist";
    }


    @GetMapping("/detail")
    public String update(Model model, @RequestParam(required = false) Long id)
    {


        model.addAttribute("users",userRepository.findAll());

        if(id == null)
        {
            model.addAttribute("auser", new User());
        }
        else
        {
             model.addAttribute("auser", userRepository.findById(id).orElse(new User()));
        }
        return "/user/formlist";
    }
}
