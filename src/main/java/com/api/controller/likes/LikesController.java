package com.api.controller.likes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/likes")
public class LikesController {

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok("Hello");
    }

}
