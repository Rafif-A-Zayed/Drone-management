package com.drones.exception;

public class MissingMandatoryException  extends RuntimeException{

    public MissingMandatoryException(String message){

        super(message);
    }
}

