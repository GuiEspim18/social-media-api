package com.api.model.likes;

import com.api.model.likes.dto.LikesDTO;
import com.api.model.posts.Posts;
import com.api.model.users.Users;
import jakarta.persistence.*;

@Entity(name = "likes")
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public Users user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    public Posts post;

    public Likes() {
    }

    public Likes(Posts post, Users user) {

    }

}
