package com.project.offer.exceptions;

public class UserWithSuchLoginAlreadyExistsException extends RuntimeException {

    public UserWithSuchLoginAlreadyExistsException(String message){
        super(message);
    }
}
