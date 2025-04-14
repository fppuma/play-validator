package com.example.play.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.play.model.User;

@RestController
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        // Process the valid user registration
        return ResponseEntity.ok("User registered successfully");
    }
}
