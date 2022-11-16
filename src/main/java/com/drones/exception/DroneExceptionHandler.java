package com.drones.exception;


import com.drones.util.ErrorResponse;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class DroneExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(NotFoundException exp) {
        return new ResponseEntity<>(ErrorResponse.builder().status(HttpStatus.NOT_FOUND.value()).error(exp.getMessage()).build(),
                HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler({InvalidInputException.class, MissingMandatoryException.class, MethodArgumentNotValidException.class,IllegalStateException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> invalidInput(RuntimeException exp) {
        return new ResponseEntity<>(ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).error(exp.getMessage()).build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorResponse>handleInvalidOperationException(InvalidOperationException exp) { //
        return new ResponseEntity<>( ErrorResponse.builder().status(HttpStatus.FORBIDDEN.value()).error(exp.getMessage()).build(),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse>handleServerException(Exception exp) { //
        return new ResponseEntity<>( ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).error(exp.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
