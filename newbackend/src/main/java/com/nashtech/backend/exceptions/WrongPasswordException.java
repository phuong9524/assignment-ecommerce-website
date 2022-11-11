package com.nashtech.backend.exceptions;

public class WrongPasswordException extends RuntimeException{
    private static final Integer serialVersionUID = 1;

    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
