package com.api.model.users;

import com.api.model.users.dto.UsersDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    List<UsersDetailsDTO> findByActiveTrue();
}
