package com.api.model.users;

import com.api.model.users.dto.UsersDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    List<UsersDetailsDTO> findByActiveTrue();


}
