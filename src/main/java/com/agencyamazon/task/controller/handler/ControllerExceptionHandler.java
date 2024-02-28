package com.agencyamazon.task.controller.handler;

import com.agencyamazon.task.exception.DataNotFoundException;
import com.agencyamazon.task.exception.DataNotValidException;
import com.agencyamazon.task.exception.DuplicateDataException;
import com.agencyamazon.task.exception.UnauthenticatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("Handling MethodArgumentNotValidException", exception);
        return createValidationErrorResponse(exception.getBindingResult().getFieldErrors());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateDataException.class)
    public Map<String, String> handleDuplicateDataException(DuplicateDataException exception) {
        log.error("Handling DuplicateDataException", exception);
        return createErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthenticatedException.class)
    public Map<String, String> handleUnauthenticatedException(UnauthenticatedException exception) {
        log.error("Handling UnauthenticatedException", exception);
        return createErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    public Map<String, String> handleDataNotFoundException(DataNotFoundException exception) {
        log.error("Handling DataNotFoundException", exception);
        return createErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(DataNotValidException.class)
    public Map<String, String> handleDataNotValidException(DataNotValidException exception) {
        log.error("Handling DataNotValidException", exception);
        return createErrorResponse(exception.getMessage());
    }

    private Map<String, String> createErrorResponse(String errorMessage) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", errorMessage);
        return errorMap;
    }

    private Map<String, String> createValidationErrorResponse(List<FieldError> fieldErrors) {
        Map<String, String> errorMap = new HashMap<>();
        fieldErrors.forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        return errorMap;
    }

}
