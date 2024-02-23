package com.api.model.posts.dto;

import com.api.model.posts.Posts;
import com.api.model.users.dto.UsersDetailsOnPostsDTO;

public record PostDetailsDTO(
        String content,
        UsersDetailsOnPostsDTO user
) {
    public PostDetailsDTO(Posts post) {
        this(post.content, new UsersDetailsOnPostsDTO(post.user));
    }
}