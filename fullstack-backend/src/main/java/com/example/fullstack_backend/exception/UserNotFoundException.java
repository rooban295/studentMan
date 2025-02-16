package com.example.fullstack_backend.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long id) {
        super("Could not found user "+ id);
    }
}
