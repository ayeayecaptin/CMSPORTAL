package com.daniel.cmsportal.model;

import com.daniel.cmsportal.model.enumeration.Room;
import com.daniel.cmsportal.model.enumeration.Semester;
import com.daniel.cmsportal.util.LocalDateConverter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer schoolyear;

    private Semester semester;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mainteacher_id", referencedColumnName = "id")
    private Faculty mainteacher;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "assistantteacher_id", referencedColumnName = "id")
    private Faculty assitantteacher;

    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startdate;

    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enddate;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classroom_id")
    private List<Student> students;

    private Room roomname;

    private String note;


}
