package com.nashtech.backend.exceptions;

public class RoleNotFoundException extends RuntimeException{

    private static final Integer serialVersionUID = 1;

    public RoleNotFoundException() {
        super();
    }

    public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
