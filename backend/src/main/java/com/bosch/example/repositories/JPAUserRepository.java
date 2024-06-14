package com.bosch.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bosch.example.model.User;

@Repository
public interface JPAUserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailContaining(String email);
    List<User> findByUsernameContaining(String username);
}
