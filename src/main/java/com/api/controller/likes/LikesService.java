package com.api.controller.likes;

import com.api.infra.security.TokenService;
import com.api.model.likes.Likes;
import com.api.model.likes.LikesRepository;
import com.api.model.likes.dto.LikesDTO;
import com.api.model.posts.Posts;
import com.api.model.posts.PostsRepository;
import com.api.model.users.Users;
import com.api.model.users.UsersRepository;
import com.api.utils.exceptions.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LikesService extends Exceptions {

    @Autowired
    private LikesRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<?> getAll() {
        List<Likes> found = repository.findAll();
        return ResponseEntity.ok(found);
    }

    public ResponseEntity<?> create(LikesDTO data, String token) {
        boolean isTheUser = this.isTheUser(data.user(), token);
        if (isTheUser) {
            Users user = usersRepository.findById(data.user()).orElseThrow(RuntimeException::new);
            Likes like = repository.findByUser(user);
            if (like == null) {
                return save(data, user);
            } else {
                if (!(like.post.id.equals(data.post()))) {
                    return save(data, user);
                }
                repository.delete(like);
                return ResponseEntity.noContent().build();
            }
        }
        return sendForbidden();
    }

    private ResponseEntity<?> save(LikesDTO data, Users user) {
        Posts post = postsRepository.findById(data.post()).orElseThrow(RuntimeException::new);
        System.out.println(new Likes(post, user).post);
        repository.save(new Likes(post, user));
        return ResponseEntity.ok(data);
    }

    private boolean isTheUser(Long user, String token) {
        String formatedToken = tokenService.formatToken(token);
        Users foundByToken = usersRepository.findByEmail(tokenService.getSubject(formatedToken));
        return Objects.equals(foundByToken.id, user);
    }

}
