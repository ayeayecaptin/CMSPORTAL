package com.daniel.cmsportal.controller;

import com.daniel.cmsportal.Repository.RoleRepository;
import com.daniel.cmsportal.Repository.UserRepository;
import com.daniel.cmsportal.Service.UserService;
import com.daniel.cmsportal.model.Role;
import com.daniel.cmsportal.model.User;
import com.daniel.cmsportal.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/list")
    public String getAll(Model model)
    {
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);

        return "/user/list";
    }



 /*   @GetMapping("/formlist")
    public String getAllForm(Model model)
    {

        List<User> users = userRepository.findAll();

        model.addAttribute("users",users);
        model.addAttribute("auser", new UserDTO(new User()));
        model.addAttribute("allroles", roleRepository.findAll());

        return "/user/formlist";
    }
*/

    @PostMapping("/formlist")
    public String addUpdateUser(UserDTO userdto, HttpServletRequest request)
    {
        userService.save(userdto);
        return "redirect:"+ request.getHeader("Referer");
    }

    @PostMapping("/delete")
    public String del(@RequestParam(required = true) Long id,  UserDTO userdto)
    {
        userService.save(userdto.getUser());
        return "redirect:/user/formlist";
    }


    @GetMapping("/formlist")
    public String update(Model model, @RequestParam(required = false) Long id)
    {


        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("allroles", roleRepository.findAll());
        if(id == null)
        {
            model.addAttribute("auser",new UserDTO(new User()));
        }else{
            model.addAttribute("auser", new UserDTO(userRepository.findById(id).orElse(new User())));
        }


        return "/user/formlist";
    }


/*
    @GetMapping("/addrole")
    public String addrole(@RequestParam(required = true, name = "userid") Long userid, @RequestParam(required = true, name = "roleid") Long roleid)
    {


        User user  = userRepository.findById(userid).orElse(null);

        Role role = roleRepository.findById(roleid).orElse(null);


        if(user != null && role != null)
        {
            user.getRoles().put(role.getId(), role);
        }
        return "redirect:/user/formlist";
    }
*/

    @GetMapping("/removerole")
    public String removerole(@RequestParam(required = true, name = "userid") Long userid, @RequestParam(required = true, name = "roleid") Long roleid)
    {


        User user  = userRepository.findByid(userid);
        Role role = roleRepository.findByid(roleid);


        if(user != null && roleid != null)
        {
            userService.DeleteRole(user, roleid);


        }
        return "redirect:/user/formlist?id=" + userid ;
    }
}
