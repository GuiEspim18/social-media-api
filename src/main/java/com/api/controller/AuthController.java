package com.api.controller;

import com.api.model.login.dto.LoginDTO;
import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.utils.exceptions.Exceptions;
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
public class AuthController extends Exceptions {

    @Autowired
    private UsersRepository repository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO data) {
        Users user = repository.findByEmail(data.email());
        if (user == null) {
            return sendResponse("Not found user!", 404);
        }
        boolean passwordMatches = user.comparePassword(data.password());
        if (passwordMatches) {
            String message = "Hello, " + user.username + "!";
            return sendResponse(message);
        } else {
            return sendResponse("Incorrect password!");
        }
    }

}
