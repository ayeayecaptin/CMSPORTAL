package com.daniel.cmsportal.model;

import com.daniel.cmsportal.util.LocalDateConverter;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.persister.walking.internal.FetchStrategyHelper;
import org.hibernate.type.descriptor.sql.LongVarcharTypeDescriptor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountnumber;

    private String name;

    private String note;

    private String enabled;
    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<User> users = new ArrayList<>();

    @Transient
    private User addUser;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Student> students = new ArrayList<>();

    @Transient
    private Student addStudent;

}
