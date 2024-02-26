package com.api.model.likes.dto;

import jakarta.validation.constraints.NotNull;

public record LikesDTO(
        @NotNull
        Long user,
        @NotNull
        Long post
) {
}
