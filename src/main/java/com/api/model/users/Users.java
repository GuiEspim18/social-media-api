package com.api.model.users;

import com.api.model.users.dto.UsersDTO;
import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String username;
    public String email;
    private String password;
    public boolean online;
    public Date createdAt;
    public boolean active;

    public Users(UsersDTO data) {
        this.username = data.username();
        this.email = data.email();
        this.password = hashPassword(data.password());
        this.active = true;
        this.online = false;
        this.createdAt = new Date();
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(password);
        return hash;
    }

}
