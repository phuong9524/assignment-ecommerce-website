package com.nashtech.backend.exceptions;

public class ProductCategoryNotFoundException extends RuntimeException{

    private static final Integer serialVersionUID = 1;

    public ProductCategoryNotFoundException() {
        super();
    }

    public ProductCategoryNotFoundException(String message) {
        super(message);
    }

    public ProductCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
