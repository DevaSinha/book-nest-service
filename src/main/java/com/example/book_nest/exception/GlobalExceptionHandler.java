package com.example.book_nest.exception;

import com.example.book_nest.domain.response.Error;
import com.example.book_nest.domain.response.ErrorResponse;
import com.example.book_nest.exception.user.AuthenticationException;
import com.example.book_nest.exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException ex) {
		Error error = new Error(ex.getCode().getValue(), List.of(ex.getMessage()));
		return new ResponseEntity<>(new ErrorResponse(error), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler({ UserNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
		Error error = new Error(ex.getCode().getValue(), List.of(ex.getMessage()));
		return new ResponseEntity<>(new ErrorResponse(error), HttpStatus.NOT_FOUND);
	}

}
