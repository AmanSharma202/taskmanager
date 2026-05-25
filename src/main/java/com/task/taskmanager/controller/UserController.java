package com.task.taskmanager.controller;

import com.task.taskmanager.DTO.*;
import com.task.taskmanager.entity.User;
import com.task.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/signup")
    ResponseEntity<?> signup(@RequestBody User user) {

        try {
            userRepository.save(user);

            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed, Try after some time");

        }
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {


        try {
            User presentUser = userRepository.findByEmail(loginRequest.getEmail());
        if (presentUser.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(presentUser);
        }

    }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed, Try after some time");
        }


        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
