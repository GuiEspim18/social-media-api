package com.api.controller.auth;

import com.api.infra.security.TokenService;
import com.api.infra.security.dto.TokenDTO;
import com.api.model.login.dto.LoginDTO;
import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.utils.exceptions.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends Exceptions {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<?> login (LoginDTO data) {
        Users user = repository.findByEmail(data.email());
        if (user == null) {
            return sendResponse("Not found user!", 404);
        }
        boolean passwordMatches = user.comparePassword(data.password());
        if (passwordMatches) {
            String jwt = tokenService.generate(user);
            return ResponseEntity.ok(new TokenDTO(jwt));
        } else {
            return sendResponse("Incorrect password!");
        }
    }

}
