package com.example.fullstack_backend.controller;


import com.example.fullstack_backend.model.User;
import com.example.fullstack_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/adduser")
    public ResponseEntity<User> adduser(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping("/")
    public List<User> getUser(){
        return service.getUser();
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> findByUserName(@PathVariable Long id){
        return service.findUserById(id);
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> UserUpdateUser(@RequestBody User newUser,@PathVariable Long id){
        User user = service.findUserById(id).getBody();
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        return service.addUser(user);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> DeleteUserById(@PathVariable Long id){

        return service.DeleteUserById(id);
    }
}
