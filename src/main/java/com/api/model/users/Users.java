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
    public boolean online = false;
    public Date createdAt;

    public Users(UsersDTO data) {
        this.username = data.username();
        this.email = data.email();
        this.password = hashPassword(data.password());

    }


    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(password);
        return hash;
    }

}
