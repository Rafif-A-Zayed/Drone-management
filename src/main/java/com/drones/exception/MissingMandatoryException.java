package com.drones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingMandatoryException  extends RuntimeException{

    public MissingMandatoryException(String message){

        super(message);
    }
}

