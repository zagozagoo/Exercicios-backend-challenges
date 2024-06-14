package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bosch.example.dto.UserResult;
import com.bosch.example.model.User;

import com.bosch.example.Services.UserUpdateService;

@RestController
public class UserUpdateController {
    @Autowired
    UserUpdateService repo;

    @PatchMapping("/changepass") 
    public UserResult updateUser(@RequestyBody User user) {

    }
}