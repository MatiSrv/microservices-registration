package com.project.template.controllers;


import java.time.ZonedDateTime;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.template.dtos.common.ErrorApi;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorApi> handleError(DuplicateKeyException exception) {
        ErrorApi error = builderError(exception.getMessage(), HttpStatus.CONFLICT);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApi> handleError(Exception exception) {
        ErrorApi error = builderError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }


    private ErrorApi builderError(String message, HttpStatus status) {
        return ErrorApi.builder()
        .timestamp(String.valueOf(java.sql.Timestamp.from(ZonedDateTime.now().toInstant())))
       .error(status.getReasonPhrase())
       .status(status.value())
       .message(message)
       .build();
    }

}
