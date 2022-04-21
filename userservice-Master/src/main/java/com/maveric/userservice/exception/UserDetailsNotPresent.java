package com.maveric.userservice.exception;

public class UserDetailsNotPresent extends RuntimeException {
    public UserDetailsNotPresent(String message) {
        super(message);
    }
}
