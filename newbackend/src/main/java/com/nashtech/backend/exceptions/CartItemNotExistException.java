package com.nashtech.backend.exceptions;

public class CartItemNotExistException extends IllegalArgumentException{
    public CartItemNotExistException(String msg) {
        super(msg);
    }
}
