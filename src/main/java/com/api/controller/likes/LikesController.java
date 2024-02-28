package com.api.controller.likes;

import com.api.model.likes.dto.LikesDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return likesService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid LikesDTO data) {
        return ResponseEntity.ok("Create");
    }

}
