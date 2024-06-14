package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.Services.UserService;
import com.bosch.example.model.User;

// Exercício 6

@RestController
public class UserController {

    @Autowired
    UserService repo;

    @PostMapping("/create")
    public String  createUser(@RequestBody User user) {
        if (!repo.validateLenght(user)){
            return "Cada campo deve ter mais que 4 dígitos!";
        }

        if (!repo.validateEmailFormat(user)){
            return "O email deve ser como: exemplo@gmail.com";
        }

        if (!repo.validateEmail(user)) {
            return "Email já cadastrado!";
        }
        if (!repo.validateUsername(user)) {
            return "Username já cadastrado!";
        }
        if (!repo.validatePassword(user)) {
            return "Senha não atinge os critérios definidos!";
        }
        
        repo.save(user);
        return "Conta criada!";
    }
    
}
