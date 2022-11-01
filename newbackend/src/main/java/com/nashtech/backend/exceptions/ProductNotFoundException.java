package com.nashtech.backend.exceptions;

public class ProductNotFoundException extends RuntimeException{
    private static final Integer serialVersionUID = 1;

    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

