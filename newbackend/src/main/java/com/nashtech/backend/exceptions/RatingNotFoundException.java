package com.nashtech.backend.exceptions;

public class RatingNotFoundException extends RuntimeException {
    private static final Integer serialVersionUID = 1;

    public RatingNotFoundException() {
        super();
    }

    public RatingNotFoundException(String message) {
        super(message);
    }

    public RatingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
