package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.ErrorNotification;
import com.airlines.yourairlines.exception.NotFoundException;
import com.airlines.yourairlines.exception.ValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(NotFoundException.class)
    public ErrorNotification handleNotFoundException(NotFoundException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessage(e.getMessage());
        return errorNotification;
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorNotification handlerRuntimeException(RuntimeException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessage(e.getMessage());
        return errorNotification;
    }

    @ExceptionHandler(ValidationException.class)
    public ErrorNotification handlerValidationException(ValidationException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessage(e.getMessage());
        return errorNotification;
    }

    @ExceptionHandler(IOException.class)
    public ErrorNotification handlerIOException(IOException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessage(e.getMessage());
        return errorNotification;
    }
}
