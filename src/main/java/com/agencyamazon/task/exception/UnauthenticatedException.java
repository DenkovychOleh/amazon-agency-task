package com.agencyamazon.task.exception;

public class UnauthenticatedException extends RuntimeException  {

    public UnauthenticatedException(String message) {
        super(message);
    }

    public UnauthenticatedException() {
        super("The user is not authenticated");
    }

}

