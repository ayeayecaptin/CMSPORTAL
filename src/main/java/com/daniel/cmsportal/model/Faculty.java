package com.daniel.cmsportal.model;

import com.daniel.cmsportal.model.enumeration.FacultyRole;
import com.daniel.cmsportal.util.LocalDateConverter;
import lombok.Data;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startdate;

    private Boolean active;
    private String ssn;
    private FacultyRole role;

}
