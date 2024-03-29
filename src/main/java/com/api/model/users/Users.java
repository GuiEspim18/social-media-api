package com.api.model.users;

import com.api.model.likes.Likes;
import com.api.model.posts.Posts;
import com.api.model.users.dto.UpdateUsersDTO;
import com.api.model.users.dto.UsersDTO;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

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

    private String authorities;

    public String bio;

    @OneToMany(mappedBy = "user")
    public List<Posts> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @Column(nullable = true)
    public List<Likes> likes = new ArrayList<>();

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

    public boolean isAdmin () {
        Collection<? extends GrantedAuthority> adminAuthorities = List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return List.of(new SimpleGrantedAuthority(this.authorities)).equals(adminAuthorities) ;
    }

    public boolean isActivated() {
        return this.active;
    }

    public void update(UpdateUsersDTO update) {
        if (update.username() != null) {
            this.username = update.username();
        }
        if (update.bio() != null) {
            this.bio = update.bio();
        }
    }
}
