package com.example.relationships.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.relationships.dao.UserRepository;
import com.example.relationships.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> addUser(List<User> users) {
        // Implement logic to add users
        // Ensure that the Department is saved before saving the User entities
        users.forEach(user -> {
            if (user.getDepartment() != null && user.getDepartment().getId() == null) {
                // Save the Department first if it's new
                user.getDepartment().setUsers(List.of(user));
            }
        });
        return userRepository.saveAll(users);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        // Implement logic to update user
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update fields as needed
            existingUser.setUsername(user.getUsername());
            // Update other fields
            return userRepository.save(existingUser);
        }
        return null;
    }
}
