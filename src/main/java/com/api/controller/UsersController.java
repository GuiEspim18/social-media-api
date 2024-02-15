package com.api.controller;

import com.api.model.users.Users;
import com.api.model.users.dto.UsersDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping
    public String findAll() {
        return "Hello user!";
    }

    @PostMapping
    public void create(@RequestBody UsersDTO data) {
        Users user = new Users(data);
        System.out.println(user);
    }

}
