package com.api.controller.users;

import com.api.infra.security.TokenService;
import com.api.model.users.dto.UpdateUsersDTO;
import com.api.model.users.dto.UsersDTO;
import com.api.utils.exceptions.Exceptions;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController extends Exceptions {

    @Autowired
    private UsersService service;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UsersDTO data) {
        return service.create(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return service.delete(id, tokenService.formatToken(token));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid UpdateUsersDTO data, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return service.update(data, tokenService.formatToken(token));
    }

}
