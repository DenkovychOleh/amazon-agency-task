package com.agencyamazon.task.exception;

public class DuplicateDataException extends RuntimeException {

    public DuplicateDataException(String message) {
        super("Duplicate data: " + message);
    }

}
