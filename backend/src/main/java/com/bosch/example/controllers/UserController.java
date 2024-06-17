package com.bosch.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.Services.UserService;
import com.bosch.example.dto.PassDto;
import com.bosch.example.dto.UserResult;
import com.bosch.example.model.User;

// Exercício 6

@RestController
public class UserController {

    @Autowired
    UserService repo;

    @PostMapping("/create")
    public UserResult createUser(@RequestBody User user) {
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


    @PatchMapping("/changepassword")
    public UserResult updateResult(@RequestBody PassDto user) {

        List<User> change = repo.findByUsernameContaining(user.username());

        if (change.size() == 0) {
            return new UserResult("Usuário não encontrado!");
        }
        
        if (!(user.newPassword().equals(user.repeatPassword()))) {
            return new UserResult("Senhas não coincidem!");
        }

        User userChange = change.get(0);
        userChange.setPassword(user.newPassword());

        if (!repo.validateLenght(userChange)){
            return new UserResult("Cada campo deve ter mais que 4 dígitos!");
        }

        if (!repo.validatePassword(userChange)) {
            return new UserResult("Senha não atinge os critérios definidos!");
        }
        repo.save(userChange);
        return new UserResult("Conta atualizada com sucesso!");
    }
    
}
