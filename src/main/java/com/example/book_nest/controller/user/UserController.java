package com.example.book_nest.controller.user;

import com.example.book_nest.domain.response.ErrorResponse;
import com.example.book_nest.domain.response.SuccessResponse;
import com.example.book_nest.domain.user.User;
import com.example.book_nest.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/v1/users")
@CrossOrigin
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Operation(summary = "Create User")
	@ApiResponses(
			value = { @ApiResponse(responseCode = "201", description = "User created successfully"),
					@ApiResponse(
							responseCode = "400",
							description = "Invalid request",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
					@ApiResponse(
							responseCode = "500",
							description = "Server error",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
	@PostMapping("/register")
	public ResponseEntity<SuccessResponse<User>> createUser(@RequestBody @Valid User user) {
		return new ResponseEntity<>(new SuccessResponse<>(userService.saveUser(user)), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	@Operation(summary = "Fetch All User")
	@ApiResponses(
			value = { @ApiResponse(responseCode = "200", description = "Users fetched successfully"),
					@ApiResponse(
							responseCode = "400",
							description = "Invalid request",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
					@ApiResponse(
							responseCode = "500",
							description = "Server error",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping
	public ResponseEntity<SuccessResponse<List<User>>> getAllUsers() {
		return ResponseEntity.ok(new SuccessResponse<>(userService.getAllUsers()));
	}
}
