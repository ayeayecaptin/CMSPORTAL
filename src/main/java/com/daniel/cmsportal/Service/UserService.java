package com.daniel.cmsportal.Service;

import com.daniel.cmsportal.Repository.UserRepository;
import com.daniel.cmsportal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncorder;


    public User save(User user){
        user.setEnabled(true);
        user.setPassword(passwordEncorder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
