package com.daniel.cmsportal.Repository;

import com.daniel.cmsportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long > {
    public List<User> findAll();

    public User findByusername(String username);

    public User findByid(Long id);

}
