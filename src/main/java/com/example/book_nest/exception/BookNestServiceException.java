package com.example.book_nest.exception;

import lombok.Getter;

public class BookNestServiceException extends RuntimeException {
    @Getter
    private final ExceptionCode code;
    private final String message;
    public BookNestServiceException(ExceptionCode code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    ;
    @Override
    public String getMessage() {
        return message;
    }
}
