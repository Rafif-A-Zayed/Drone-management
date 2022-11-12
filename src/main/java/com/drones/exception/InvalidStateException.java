package com.drones.exception;


public class InvalidStateException extends RuntimeException{

    public InvalidStateException(String message){
        super(message);
    }
}
