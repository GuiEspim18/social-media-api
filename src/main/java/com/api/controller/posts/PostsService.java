package com.api.controller.posts;

import com.api.model.posts.Posts;
import com.api.model.posts.PostsRepository;
import com.api.model.posts.dto.PostDetailsDTO;
import com.api.model.posts.dto.PostsDTO;
import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {

    @Autowired
    private PostsRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<?> getAll() {
        List<Posts> found = repository.findByActiveTrue();
        List<PostDetailsDTO> posts = found.stream().map(PostDetailsDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(posts);
    }

    public ResponseEntity<?> create(PostsDTO data) {
        Users user = usersRepository.findById(data.user()).orElseThrow(RuntimeException::new);
        Posts post = new Posts(data.content(), user);
        repository.save(post);
        return ResponseEntity.ok(new PostDetailsDTO(post));
    }

}
