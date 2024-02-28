package com.api.controller.likes;

import com.api.model.likes.Likes;
import com.api.model.likes.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {

    @Autowired
    private LikesRepository repository;

    public ResponseEntity<?> getAll() {
        List<Likes> found = repository.findAll();
        return ResponseEntity.ok(found);
    }

}
