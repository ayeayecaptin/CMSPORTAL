package com.daniel.cmsportal.model;

import com.daniel.cmsportal.util.LocalDateConverter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class AccountDTO {

   public AccountDTO(){}

   public AccountDTO(Account account){
       id = account.getId();
       accountnumber = account.getAccountnumber();
       name = account.getName();
       note = account.getName();
       enabled = account.getEnabled();
       createdate = account.getCreatedate();

   }

    private Long id;

    private String accountnumber;

    private String name;

    private String note;

    private String enabled;
    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdate;

    private User userappend;

    private Student studentappend;

    private List<User> users = new ArrayList<>();

    private List<Student> students = new ArrayList<>();

}
