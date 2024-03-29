package com.api.model.posts;

import com.api.model.likes.Likes;
import com.api.model.users.Users;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Posts")
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public Users user;

    @OneToMany(mappedBy = "post")
    @Column(nullable = true)
    public List<Likes> likes = new ArrayList<>();

    @Column(columnDefinition = "TINYINT(1)")
    public boolean active;

    public Posts() {
    }

    public Posts (String content, Users user) {
        this.content = content;
        this.user = user;
        this.active = true;
    }


}
