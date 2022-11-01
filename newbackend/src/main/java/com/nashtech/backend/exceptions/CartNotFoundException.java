package com.nashtech.backend.exceptions;

public class CartNotFoundException extends RuntimeException{
    private static final Integer serialVersionUID = 1;

    public CartNotFoundException() {
        super();
    }

    public CartNotFoundException(String message) {
        super(message);
    }

    public CartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
