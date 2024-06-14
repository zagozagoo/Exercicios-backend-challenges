package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.Services.UserService;
import com.bosch.example.model.User;
import com.bosch.example.repositories.JPAUserRepository;

public class IMPUser implements UserService {
    @Autowired
    JPAUserRepository repo;

    @Override
    public List<User> findByEmailContaining(String email) {
        return repo.findByEmailContaining(email);
    }

    @Override
    public List<User> findByUsernameContaining(String username) {
        return repo.findByUsernameContaining(username);
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    public boolean validateEmail(User user) {
        if(this.findByEmailContaining(user.getEmail()).size() != 0) {
            return false;
        } else {
            return true;
        }
    }
    public boolean validateUsername(User user) {
        if(this.findByUsernameContaining(user.getUsername()).size() != 0) {
            return false;
        } else {
            return true;
        }
    }

}
