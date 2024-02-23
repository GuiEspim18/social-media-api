package com.api.controller.posts;

import com.api.model.posts.dto.PostsDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService service;

    @GetMapping
    public ResponseEntity<?> getAll () {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PostsDTO data) {
        return service.create(data);
    }

}
