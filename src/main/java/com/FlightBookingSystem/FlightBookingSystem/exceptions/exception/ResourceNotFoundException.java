package com.FlightBookingSystem.FlightBookingSystem.exceptions.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
