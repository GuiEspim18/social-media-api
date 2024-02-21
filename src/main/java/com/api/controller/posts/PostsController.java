package com.api.controller.posts;

import com.api.model.posts.dto.PostsDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @GetMapping
    public ResponseEntity<?> getAll () {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PostsDTO data) {
        return ResponseEntity.ok(data);
    }

}
