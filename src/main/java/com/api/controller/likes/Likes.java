package com.api.controller.likes;

import jakarta.persistence.*;

@Entity(name = "Likes")
@Table(name = "likes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

}
