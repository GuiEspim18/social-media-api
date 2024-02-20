package com.api.model.posts;

import com.api.model.users.Users;
import jakarta.persistence.*;

@Entity(name = "Posts")
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public Users user;


}
