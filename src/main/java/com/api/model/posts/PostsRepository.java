package com.api.model.posts;

import com.api.model.posts.dto.PostDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findByActiveTrue();
}
