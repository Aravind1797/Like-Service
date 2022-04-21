package com.maveric.userservice.exception;

public class UserEmailAlreadyExist extends RuntimeException {
    public UserEmailAlreadyExist(String message) {
        super(message);
    }
}
