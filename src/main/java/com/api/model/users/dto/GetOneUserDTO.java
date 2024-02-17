package com.api.model.users.dto;

import com.api.model.users.Users;

import java.util.Date;

public record GetOneUserDTO(
        Long id,
        String username,
        String email,
        Date createdAt
) {
    public GetOneUserDTO(Users user) {
        this(user.id, user.username, user.email, user.createdAt);
    }
}
