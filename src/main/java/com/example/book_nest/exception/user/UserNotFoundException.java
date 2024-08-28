package com.example.book_nest.exception.user;

import com.example.book_nest.exception.BookNestServiceException;
import com.example.book_nest.exception.ExceptionCode;

public class UserNotFoundException extends BookNestServiceException {
    public UserNotFoundException(String message) {
        super(ExceptionCode.USER_NOT_FOUND_EXCEPTION, message);
    }
}
