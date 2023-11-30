package com.springboot.uts_praktikum_java.repository;

import com.springboot.uts_praktikum_java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}