package com.daniel.cmsportal.Repository;

import com.daniel.cmsportal.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyReository extends JpaRepository<Faculty, Long> {

    public Faculty findByid(Long id);
}
