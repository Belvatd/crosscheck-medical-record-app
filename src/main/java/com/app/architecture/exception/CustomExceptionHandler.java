package com.app.architecture.exception;

import com.app.architecture.exception.core.ArchitectureException;
import com.app.architecture.exception.core.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ArchitectureException.class)
    public final ResponseEntity<ErrorResponse> handle(ArchitectureException exception) {
        ErrorResponse response = new ErrorResponse(exception);
        return ResponseEntity
                .status(exception.getStatus())
                .body(response);
    }
}