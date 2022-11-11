package com.nashtech.backend.exceptions;

public class UsernameNotFoundException extends RuntimeException {

    private static final Integer serialVersionUID = 1;

    public UsernameNotFoundException() {
        super();
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

