package com.example.book_nest.controller.user;

import com.example.book_nest.domain.response.ErrorResponse;
import com.example.book_nest.domain.response.SuccessResponse;
import com.example.book_nest.domain.user.User;
import com.example.book_nest.dto.user.AuthUser;
import com.example.book_nest.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/v1/login")
@CrossOrigin
public class LoginController {
	private final UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@Operation(summary = "Login user")
	@ApiResponses(
			value = { @ApiResponse(responseCode = "200", description = "logged in successfully"),
					@ApiResponse(
							responseCode = "400",
							description = "Invalid request",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
					@ApiResponse(
							responseCode = "500",
							description = "Server error",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
	@PostMapping
	public ResponseEntity<SuccessResponse<User>> login(@RequestBody AuthUser userData) {
		User user = userService.verifyUser(userData);
		return ResponseEntity.ok(new SuccessResponse<>(user));
	};
}
