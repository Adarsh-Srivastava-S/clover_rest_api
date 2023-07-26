package com.cloverleaf.clover_api.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String message)
    {
        super(message);
    }
}
