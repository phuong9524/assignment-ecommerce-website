package com.nashtech.backend.exceptions;

public class CartItemNotExistException extends IllegalArgumentException{

    private static final Integer serialVersionUID = 1;

    public CartItemNotExistException() {
        super();
    }

    public CartItemNotExistException(String message) {
        super(message);
    }

    public CartItemNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
