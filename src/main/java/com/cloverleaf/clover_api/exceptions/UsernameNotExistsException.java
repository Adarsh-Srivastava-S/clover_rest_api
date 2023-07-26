package com.cloverleaf.clover_api.exceptions;

public class UsernameNotExistsException extends RuntimeException{
    public UsernameNotExistsException(String message)
    {
        super(message);
    }
}
