package com.daniel.cmsportal.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name ="account_id")
    private Account account;

    @ManyToMany
    @JoinTable(
            name="User_Role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @MapKey(name="id")

    private Map<Long,Role> roles = new HashMap<Long,Role>();





}
