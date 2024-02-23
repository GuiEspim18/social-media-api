package com.api.model.users.dto;

import com.api.model.posts.dto.PostsByUserDTO;
import com.api.model.users.Users;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public record GetOneUserDTO(
        Long id,
        String username,
        String email,
        Date createdAt,
        String bio,
        List<PostsByUserDTO> posts
) {
    public GetOneUserDTO(Users user) {
        this(user.id, user.username, user.email, user.createdAt, user.bio, user.posts.stream().map(PostsByUserDTO::new).collect(Collectors.toList()));
    }
}
