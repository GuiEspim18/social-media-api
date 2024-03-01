package com.api.model.posts.dto;

import com.api.model.posts.Posts;
import com.api.model.users.dto.UsersDetailsOnPostsDTO;

public record PostDetailsDTO(
        Long id,
        String content,
        UsersDetailsOnPostsDTO user,
        int likes
) {
    public PostDetailsDTO(Posts post) {
        this(post.id,  post.content, new UsersDetailsOnPostsDTO(post.user), post.likes.size());
    }
}
