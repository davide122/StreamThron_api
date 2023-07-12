package com.project.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.streaming.entity.User;
import com.project.streaming.model.Movies;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
}
