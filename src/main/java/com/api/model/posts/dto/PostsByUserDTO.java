package com.api.model.posts.dto;

import com.api.model.posts.Posts;

public record PostsByUserDTO(
        Long id,
        String content
) {
    public PostsByUserDTO(Posts post) {
        this(post.id, post.content);
    }
}
