package com.api.controller.users;

import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.model.users.dto.UsersDTO;
import com.api.model.users.dto.UsersDetailsDTO;
import com.api.utils.exceptions.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService extends Exceptions {

    @Autowired
    private UsersRepository repository;

    public ResponseEntity<?> create(UsersDTO data) {
        Users found = repository.findByEmail(data.email());
        if (found == null) {
            Users user = new Users(data);
            repository.save(user);
            return ResponseEntity.ok(new UsersDetailsDTO(user));
        } else {
            return sendResponse("User already registered!", 500);
        }
    }

    public ResponseEntity<?> getAll() {
        List<UsersDetailsDTO> users = repository.findByActiveTrue();
        return ResponseEntity.ok(users);
    }
}
