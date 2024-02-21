package com.api.model.posts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostsDTO(
        @NotBlank
        String content,

        @NotNull
        Long user
) {
}
