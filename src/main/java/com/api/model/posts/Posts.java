package com.api.model.posts;

import jakarta.persistence.*;

@Entity(name = "Posts")
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String content;


}
