package com.api.model.users.dto;

import com.api.model.users.Users;

public record UsersDetailsOnPostsDTO(
        Long id,
        String username
) {
    public UsersDetailsOnPostsDTO(Users user) {
        this(user.id, user.username);
    }
}
