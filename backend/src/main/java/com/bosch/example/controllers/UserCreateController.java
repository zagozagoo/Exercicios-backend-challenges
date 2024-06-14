package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.Services.UserCreateService;
import com.bosch.example.dto.UserResult;
import com.bosch.example.model.User;

// Exercício 6

@RestController
public class UserCreateController {

    @Autowired
    UserCreateService repo;

    @PostMapping("/create")
    public UserResult  createUser(@RequestBody User user) {
        if (!repo.validateLenght(user)){
            return new UserResult("Cada campo deve ter mais que 4 dígitos!");
        }

        if (!repo.validateEmailFormat(user)){
            return new UserResult("O email deve ser como: exemplo@gmail.com");
        }

        if (!repo.validateEmail(user)) {
            return new UserResult(" Email já cadastrado!");
        }
        if (!repo.validateUsername(user)) {
            return new UserResult("Username já cadastrado!");
        }
        if (!repo.validatePassword(user)) {
            return new UserResult("Senha não atinge os critérios definidos!");
        }
        
        repo.save(user);
        return new UserResult("Conta criada com sucesso!");
    }
    
}
