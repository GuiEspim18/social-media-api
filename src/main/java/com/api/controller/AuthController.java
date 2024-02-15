package com.api.controller;

import com.api.model.login.dto.LoginDTO;
import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.utils.responseBody.ResponseBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersRepository repository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO data) {
        Users user = repository.findByEmail(data.email());
        if (user == null) {
            return ResponseEntity.status(500).body(new ResponseBody("Not found user!"));
        }
        boolean passwordMatches = user.comparePassword(data.password());
        if (passwordMatches) {
            return ResponseEntity.ok(new ResponseBody("Hello, " + user.username + "!"));
        } else {
            return ResponseEntity.status(500).body(new ResponseBody("Incorrect password!"));
        }
    }

}
