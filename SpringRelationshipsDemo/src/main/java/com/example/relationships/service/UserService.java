package com.example.relationships.service;

import java.util.List;

import com.example.relationships.entity.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    List<User> addUser(List<User> users);

    void deleteUser(Long id);

    User updateUser(Long id, User user);

}


