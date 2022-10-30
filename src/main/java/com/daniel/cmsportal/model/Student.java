package com.daniel.cmsportal.model;

import com.daniel.cmsportal.util.LocalDateConverter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
//@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

   // @Column(name ="FirstName")
    private String firstname;
   // @Column(name="LastName")
    private String lastname;
  //  @Column(name="NickName")
    private String nickname;

    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String ssn;

    private String address1;

    private String address2;

    private String city;

    private String zip;

    private String note;

    private LocalDateTime createdt;

    private LocalDateTime updatedt;

    private boolean active;

    private String email;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;




}


