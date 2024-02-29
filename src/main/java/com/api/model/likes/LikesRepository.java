package com.api.model.likes;

import com.api.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Likes findByUser(Users user);
}
