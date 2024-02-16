package com.api.controller.users;

import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.model.users.dto.UsersDTO;
import com.api.model.users.dto.UsersDetailsDTO;
import com.api.utils.exceptions.Exceptions;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController extends Exceptions {

    @Autowired
    private UsersRepository repository;

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

}
