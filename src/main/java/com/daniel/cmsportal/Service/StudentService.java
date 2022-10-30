package com.daniel.cmsportal.Service;


import com.daniel.cmsportal.Repository.StudentRepository;
import com.daniel.cmsportal.model.Student;
import com.daniel.cmsportal.util.LocalDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class StudentService {

    private StudentRepository studentRepository;



    @Autowired
    public StudentService(StudentRepository studentrepository)
    {
        this.studentRepository = studentrepository;
    }

    public Student save(Student student){
        student.setActive(true);
        if (student.getCreatedt() == null )
        {
            student.setCreatedt(LocalDateTime.now());
        }

        student.setUpdatedt(LocalDateTime.now());
        return studentRepository.save(student);
    }
}
