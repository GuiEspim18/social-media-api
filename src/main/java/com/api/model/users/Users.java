package com.api.model.users;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String username;
    public String email;
    public String password;
    public boolean online = false;
    public Date createdAt;


}
