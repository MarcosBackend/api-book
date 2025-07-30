package com.books.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<ErrorResponse> handlerBookNotFound(BookNotFound bookNotFound) {
        return new ResponseEntity<>(new ErrorResponse(404, bookNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }
}
