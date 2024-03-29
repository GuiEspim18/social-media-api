package com.api.controller.users;

import com.api.infra.security.TokenService;
import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.model.users.dto.GetOneUserDTO;
import com.api.model.users.dto.UpdateUsersDTO;
import com.api.model.users.dto.UsersDTO;
import com.api.model.users.dto.UsersDetailsDTO;
import com.api.utils.exceptions.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsersService extends Exceptions {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private TokenService tokenService;

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

    public ResponseEntity<?> delete(Long id, String token) {
        Users found = findUserById(id);
        if (isAdminOrSameUser(found, token)) {
            found.disable();
            repository.save(found);
            return ResponseEntity.noContent().build();
        }
        return sendForbidden();
    }

    public ResponseEntity<?> getOne(Long id) {
        Users found = findUserById(id);
        return ResponseEntity.ok(new GetOneUserDTO(found));
    }

    private boolean isAdminOrSameUser(Users found, String token) {
        Users foundByToken = repository.findByEmail(tokenService.getSubject(token));
        return foundByToken.isAdmin() || Objects.equals(foundByToken.id, found.id);
    }

    public ResponseEntity<?> update(UpdateUsersDTO update, String token) {
        Users found = findUserById(update.id());
        if (isAdminOrSameUser(found, token)) {
            found.update(update);
            repository.save(found);
            return ResponseEntity.ok(new UsersDetailsDTO(found));
        }
        return sendForbidden();
    }

    private Users findUserById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
