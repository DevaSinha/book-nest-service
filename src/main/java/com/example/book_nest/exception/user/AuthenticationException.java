package com.example.book_nest.exception.user;

import com.example.book_nest.exception.BookNestServiceException;
import com.example.book_nest.exception.ExceptionCode;

public class AuthenticationException extends BookNestServiceException {
	public AuthenticationException(String message) {
		super(ExceptionCode.AUTHENTICATION_EXCEPTION, message);
	}
}
