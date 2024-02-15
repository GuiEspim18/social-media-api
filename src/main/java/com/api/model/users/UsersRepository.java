package com.api.model.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    List<Users> findByActiveTrue();
}
