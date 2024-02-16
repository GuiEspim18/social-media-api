package com.api.controller.users;

import com.api.model.users.dto.UsersDTO;
import com.api.utils.exceptions.Exceptions;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController extends Exceptions {

    @Autowired
    private UsersService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UsersDTO data) {
        return service.create(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

}
