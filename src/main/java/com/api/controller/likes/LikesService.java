package com.api.controller.likes;

import com.api.model.likes.Likes;
import com.api.model.likes.LikesRepository;
import com.api.model.likes.dto.LikesDTO;
import com.api.model.posts.Posts;
import com.api.model.posts.PostsRepository;
import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {

    @Autowired
    private LikesRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PostsRepository postsRepository;

    public ResponseEntity<?> getAll() {
        List<Likes> found = repository.findAll();
        return ResponseEntity.ok(found);
    }

    public ResponseEntity<?> create (LikesDTO data) {
        Users user = usersRepository.findById(data.user()).orElseThrow(RuntimeException::new);
        Likes like = repository.findByUser(user);
        if (like != null) {
            if (!(like.post.id == data.post())) {
                Posts post = postsRepository.findById(data.post()).orElseThrow(RuntimeException::new);
                repository.save(new Likes(post, user));
                return ResponseEntity.ok(data);
            }
        }
        throw new RuntimeException();
    }

}
