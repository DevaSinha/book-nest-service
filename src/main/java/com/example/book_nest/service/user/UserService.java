package com.example.book_nest.service.user;

import com.example.book_nest.domain.user.User;
import com.example.book_nest.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create or Update User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve User by ID
    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }


    // Retrieve All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Delete User by ID
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    // Additional business logic methods as needed
}

