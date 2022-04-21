package com.maveric.userservice.exception;

public class UserNotExistsException extends RuntimeException {
    public UserNotExistsException(String message) {
        super(message);
    }
}
