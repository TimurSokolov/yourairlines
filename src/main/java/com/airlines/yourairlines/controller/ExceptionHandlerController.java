package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.ErrorNotification;
import com.airlines.yourairlines.exception.AuthException;
import com.airlines.yourairlines.exception.NotFoundException;
import com.airlines.yourairlines.exception.ValidationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(NotFoundException.class)
    public ErrorNotification handleNotFoundException(NotFoundException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessages(Collections.singletonList(e.getMessage()));
        return errorNotification;
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorNotification handlerRuntimeException(RuntimeException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessages(Collections.singletonList(e.getMessage()));
        return errorNotification;
    }

    @ExceptionHandler(ValidationException.class)
    public ErrorNotification handlerValidationException(ValidationException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessages(Collections.singletonList(e.getMessage()));
        return errorNotification;
    }

    @ExceptionHandler(IOException.class)
    public ErrorNotification handlerIOException(IOException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessages(Collections.singletonList(e.getMessage()));
        return errorNotification;
    }

    @ExceptionHandler(AuthException.class)
    public ErrorNotification handleAuthException(AuthException e) {
        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessages(Collections.singletonList(e.getMessage()));
        return errorNotification;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorNotification handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }

        ErrorNotification errorNotification = new ErrorNotification();
        errorNotification.setErrorMessages(errors);
        return errorNotification;
    }
}
