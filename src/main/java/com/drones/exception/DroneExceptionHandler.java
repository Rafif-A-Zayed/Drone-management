package com.drones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DroneExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<String> resourceNotFoundException(NotFoundException exp) {
        return new ResponseEntity<>( exp.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidStateException.class, MissingMandatoryException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> invalidInput(RuntimeException exp) {
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
