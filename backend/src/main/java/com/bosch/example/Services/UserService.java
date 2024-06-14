package com.bosch.example.Services;

import java.util.List;

import com.bosch.example.model.User;

public interface UserService {
    void save(User user);
    List<User> findByEmailContaining(String user);
    List<User> findByUsernameContaining(String user);
    boolean validateUsername(User user);
    boolean validateEmail(User user);
}
