package com.api.model.users.dto;

import com.api.model.users.Users;

public record UsersDetailsDTO(
        Long id,
        String username,
        String email
) {

    public UsersDetailsDTO (Users data) {
        this(data.id, data.username, data.email);
    }

}
