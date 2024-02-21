package com.api.controller.posts;

import com.api.model.posts.Posts;
import com.api.model.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private PostsRepository repository;

    public ResponseEntity<?> getAll() {
        List<Posts> posts = repository.findAll();
        return ResponseEntity.ok(posts);
    }

}
