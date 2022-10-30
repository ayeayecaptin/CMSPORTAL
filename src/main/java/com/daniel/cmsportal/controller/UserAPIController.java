package com.daniel.cmsportal.controller;

import com.daniel.cmsportal.Repository.UserRepository;
import com.daniel.cmsportal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAPIController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> all ()
    {

            return userRepository.findAll();

    }

    @PutMapping("/{id}")
    public User update(@RequestBody User newUser,@PathVariable Long id)
    {
        return userRepository.findById(id)
                .map( user -> {
                    user.setUsername( newUser.getUsername() );
                    user.setEnabled( newUser.getEnabled());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseGet( () -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });

    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id)
    {
        userRepository.deleteById(id);
    }

}
