package com.demo_deploye.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo_deploye.dto.user.UserRequest;
import com.demo_deploye.model.User;
import com.demo_deploye.repository.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserRepo userRepo;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        var user = userRepo.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>("register fail", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        try {
            userRepo.save(user);
            return ResponseEntity.ok("register success!");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>("register fail", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest request, @PathVariable int id) {
        try {
            var user = User.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .build();
            userRepo.save(user);
            return ResponseEntity.ok("update user success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>("update user fail", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        try {
            userRepo.deleteById(id);
            return ResponseEntity.ok("delete user success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>("delete user fail", HttpStatus.BAD_REQUEST);
        }
    }
}
