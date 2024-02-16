package com.api.model.users;

import com.api.model.users.dto.UsersDTO;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String username;
    public String email;
    private String password;

    @Column(columnDefinition = "TINYINT(1)")
    public boolean online;

    public Date createdAt;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean active;

    public String authorities;

    public Users() {
    }

    public Users(UsersDTO data) {
        this.username = data.username();
        this.email = data.email();
        this.password = hashPassword(data.password());
        this.active = true;
        this.online = false;
        this.createdAt = new Date();
        this.authorities = "ROLE_USER";
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public void disable() {
        this.active = false;
    }

    public boolean comparePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, this.password);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.authorities));
    }
}
