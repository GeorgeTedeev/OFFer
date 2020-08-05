package com.project.offer.exceptions;

public class NoEntityWithSuchIdException extends RuntimeException {

    public NoEntityWithSuchIdException(String message){
        super(message);
    }
}
