package com.daniel.cmsportal.Service;

import com.daniel.cmsportal.Repository.UserRepository;
import com.daniel.cmsportal.model.Role;
import com.daniel.cmsportal.model.User;
import com.daniel.cmsportal.model.UserDTO;
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

    public User DeleteRole(User user,Long roleid)
    {
        user.getRoles().remove(roleid);
        return userRepository.save(user);
    }

    public User save(UserDTO userdto){
        Role newrole =  userdto.getRoleToAppend();
        User usertosave = userRepository.findByid(userdto.getUser().getId());
        usertosave.getRoles().putIfAbsent(newrole.getId(), newrole);
        return userRepository.save(usertosave);

    }
}
