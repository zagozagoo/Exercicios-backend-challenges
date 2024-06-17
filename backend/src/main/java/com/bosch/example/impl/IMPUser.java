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

    public boolean validateLenght (User user){
        if (user.getEmail().length() < 4) {
            return false;
        }
        if (user.getPassword().length() < 4) {
            return false;
        }
        if (user.getUsername().length() < 4) {
            return false;
        }
        return true;
    }

    public boolean validatePassword(User user) {
        String pass = user.getPassword();

        boolean maiuscula = false; 
        boolean minuscula = false;
        boolean digit = false;

        if (pass.length() < 8) {
            return false;
        }

        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if (Character.isUpperCase(ch)) {
                maiuscula = true;
            } else if (Character.isLowerCase(ch)) {
                minuscula = true;
            }
            if (Character.isDigit(ch)) {
                digit = true;
            }
        }

        if (minuscula && maiuscula && digit) {
            return true;
        }
        return false;

    } 

    public boolean validateEmailFormat(User user) {
        String email = user.getEmail();
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }

}
