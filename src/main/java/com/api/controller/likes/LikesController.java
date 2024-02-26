package com.api.controller.likes;

import com.api.model.likes.dto.LikesDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/likes")
public class LikesController {

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok("Get All");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid LikesDTO data) {
        return ResponseEntity.ok("Create");
    }

}
