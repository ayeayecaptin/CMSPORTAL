package com.daniel.cmsportal.Repository;

import com.daniel.cmsportal.model.Role;
import com.daniel.cmsportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByid(Long id);

}
