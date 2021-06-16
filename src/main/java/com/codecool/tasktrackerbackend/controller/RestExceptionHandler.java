package com.codecool.tasktrackerbackend.controller;

import com.codecool.tasktrackerbackend.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> noSuchElementExceptionHandler(NoSuchElementException exception){
        ApiError apiError = ApiError.builder().httpStatus(HttpStatus.BAD_REQUEST).timeStamp(LocalDateTime.now()).message(exception.getMessage()).build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);

    }

}
