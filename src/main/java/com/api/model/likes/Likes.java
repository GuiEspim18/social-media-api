package com.api.model.likes;

import jakarta.persistence.*;

@Entity(name = "likes")
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


}
