package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.Services.UserService;
import com.bosch.example.model.User;

@RestController
public class UserController {

    @Autowired
    UserService repo;

    @PostMapping("/create")
    public String  createUser(@RequestBody User user) {

        if (!repo.validateEmail(user)) {
            return "Email já cadastrado!";
        }
        if (!repo.validateUsername(user)) {
            return "Username já cadastrado!";
        }
        
        repo.save(user);
        return "Conta criada!";
    }
    
}
