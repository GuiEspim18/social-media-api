package com.api.controller;

import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.model.users.dto.UsersDTO;
import com.api.model.users.dto.UsersDetailsDTO;
import com.api.utils.responseBody.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public String findAll() {
        return "Hello user!";
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UsersDTO data) {
        Users found = repository.findByEmail(data.email());
        if (found == null) {
            Users user = new Users(data);
            repository.save(user);
            return ResponseEntity.ok(new UsersDetailsDTO(user));
        } else {
            return ResponseEntity.status(500).body(new ResponseBody("User already registered!"));
        }

    }

}
