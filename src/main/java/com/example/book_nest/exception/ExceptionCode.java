package com.example.book_nest.exception;

public enum ExceptionCode {
REQUEST_BODY_MISSING("BN0001"), REQUEST_PARAMETER_MISSING("BN0002"), REQUEST_TYPE_MISMATCH("BN0003"), REQUEST_DATA_VALIDATION("BN0004"), USER_NOT_FOUND_EXCEPTION("BN0005"), AUTHENTICATION_EXCEPTION("BN0006");

    private final String value;

    ExceptionCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
