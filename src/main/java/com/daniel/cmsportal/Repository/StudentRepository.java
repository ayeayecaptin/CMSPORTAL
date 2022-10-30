package com.daniel.cmsportal.Repository;


import com.daniel.cmsportal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findAll();

    public Student findByID(Long ID);

}
