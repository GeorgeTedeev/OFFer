package com.project.offer.exceptions;

public class NoSuchLoginOrPasswordException extends RuntimeException{

    public NoSuchLoginOrPasswordException(String message){
        super(message);
    }

}
