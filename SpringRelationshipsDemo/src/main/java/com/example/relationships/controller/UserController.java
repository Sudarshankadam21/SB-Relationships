package com.example.relationships.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.relationships.entity.User;
import com.example.relationships.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        List<User> addedUsers = userService.addUser(Collections.singletonList(user));
        return new ResponseEntity<>(addedUsers.get(0), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}


/*
 * [ { "username": "john_doe", "address": { "street": "123 Main Street", "city":
 * "Cityville", "zipCode": "12345" }, "roles": [ {"roleName": "ROLE_USER"},
 * {"roleName": "ROLE_ADMIN"} ], "department": { "name": "IT Department" },
 * "projects": [ {"name": "Project A"}, {"name": "Project B"} ] }, { // Another
 * user object } ]
 * 
 * 
 * 
 */