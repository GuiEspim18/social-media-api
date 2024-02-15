package com.api.controller;

import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.model.users.dto.UsersDTO;
import com.api.model.users.dto.UsersDetailsDTO;
import com.api.utils.exceptions.Exceptions;
import com.api.utils.responseBody.ResponseBody;
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

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<UsersDetailsDTO> users = repository.findByActiveTrue();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UsersDTO data) {
        Users found = repository.findByEmail(data.email());
        if (found == null) {
            Users user = new Users(data);
            repository.save(user);
            return ResponseEntity.ok(new UsersDetailsDTO(user));
        } else {
            return sendResponse("User already registered!", 500);
        }

    }

}
