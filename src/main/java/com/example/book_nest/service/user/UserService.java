package com.example.book_nest.service.user;

import com.example.book_nest.domain.user.User;
import com.example.book_nest.dto.user.AuthUser;
import com.example.book_nest.exception.user.AuthenticationException;
import com.example.book_nest.exception.user.UserNotFoundException;
import com.example.book_nest.repository.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		logger.info("Creating Account");
		return userRepository.save(user);
	}

	public Optional<User> getUserById(Integer userId) {
		return userRepository.findById(userId);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	public User verifyUser(AuthUser userData) {
		logger.info("Verifying user");
		User user = userRepository.findByEmail(userData.getEmail()).orElseThrow(() -> new UserNotFoundException("User Does Not Exist"));
		if (!checkPassword(userData.getPassword(), user.getPassword())) {
			logger.error("Authentication Failed for user {}", user.getUserId());
			throw new AuthenticationException("Wrong Password");
		}
		return user;
	}

	public boolean checkPassword(String enteredPassword, String password) {
		return passwordEncoder.matches(enteredPassword, password);
	}
}
