package com.project.template.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.project.template.models.User;
import com.project.template.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("Registration")
public class RegistrationController {

    @Autowired
    private UserService userService;
    
    @PostMapping()
    public ResponseEntity<User> registerUser( @RequestBody  @Valid User user) {
        return ResponseEntity.ok(userService.register(user));
    }
    
}
