package com.drones.exception;


import com.drones.util.ErrorResponse;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class DroneExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(NotFoundException exp) {
        return new ResponseEntity<>(ErrorResponse.builder().status(HttpStatus.NOT_FOUND.value()).error(exp.getMessage()).build(),
                HttpStatus.NOT_FOUND);


    }
    @ExceptionHandler({
            InvalidInputException.class,
            MissingMandatoryException.class,
            IllegalStateException.class,
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> invalidInput(Exception exp) {
            return new ResponseEntity<>(ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).error(exp.getMessage()).build(),
                    HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            HandlerMethodValidationException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleValidationErrors(Exception ex) {
        List<String> errors = new ArrayList<>();

        if (ex instanceof MethodArgumentNotValidException manve) {
            errors = manve.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .toList();
        }
        else if (ex instanceof HandlerMethodValidationException hmve) {
            errors = hmve.getAllErrors()
                    .stream()
                    .map(err -> {
                        if (err instanceof FieldError fe) {
                            return fe.getField() + ": " + fe.getDefaultMessage();
                        } else {
                            return err.getDefaultMessage();
                        }
                    })
                    .toList();
        }


        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation failed")
                .details(errors) // <-- Add a new list field in ErrorResponse for this
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorResponse>handleInvalidOperationException(InvalidOperationException exp) { //
        return new ResponseEntity<>( ErrorResponse.builder().status(HttpStatus.FORBIDDEN.value()).error(exp.getMessage()).build(),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleRuntime(RuntimeException exp) {
        return new ResponseEntity<>( ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).error(exp.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
