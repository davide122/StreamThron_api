package com.project.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.streaming.entity.ERole;
import com.project.streaming.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
