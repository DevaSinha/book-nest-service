package com.example.book_nest.service.user;

import com.example.book_nest.domain.user.User;
import com.example.book_nest.dto.user.AuthUser;
import com.example.book_nest.exception.user.AuthenticationException;
import com.example.book_nest.exception.user.UserNotFoundException;
import com.example.book_nest.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create or Update User
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    public User verifyUser(AuthUser userData){
        // Use Optional directly
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(userData.getEmail()));
        User user = userOptional.orElseThrow(() -> new UserNotFoundException("User Does Not Exist"));
        if (!checkPassword(userData.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Wrong Password");
        }
        return user;
    }

    public boolean checkPassword(String enteredPassword, String password) {
        return passwordEncoder.matches(enteredPassword, password);
    }
}

