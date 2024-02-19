package com.api.model.users.dto;

import jakarta.validation.constraints.NotBlank;

public record UsersDTO(
        @NotBlank
        String username,

        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotBlank
        String bio
) {
}
