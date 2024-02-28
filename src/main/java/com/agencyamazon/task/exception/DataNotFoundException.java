package com.agencyamazon.task.exception;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message + " not found.");
    }

}
