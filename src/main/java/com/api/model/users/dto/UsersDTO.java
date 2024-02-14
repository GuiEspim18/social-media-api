package com.api.model.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsersDTO(
        @NotNull
        Long id,

        @NotBlank
        String username,

        @NotBlank
        String email,

        @NotBlank
        String password


) {
}
