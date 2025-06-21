package com.FlightBookingSystem.FlightBookingSystem.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.FlightBookingSystem.FlightBookingSystem.exceptions.exception.DuplicateResourceException;
import com.FlightBookingSystem.FlightBookingSystem.exceptions.exception.ResourceNotFoundException;
import com.FlightBookingSystem.FlightBookingSystem.utils.common.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex,HttpServletRequest request){
        ErrorResponse errorResponse = buildErrorResponse(false,HttpStatus.NOT_FOUND.value(),"Resource Not Found",request.getRequestURI());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    private ResponseEntity<ErrorResponse> handleDuplicateResourceException(ResourceNotFoundException ex,HttpServletRequest request){
        ErrorResponse errorResponse = buildErrorResponse(false,HttpStatus.BAD_REQUEST.value(), "Resource already exist", request.getRequestURI());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> handleGlobalException(Exception ex,HttpServletRequest request){
        ErrorResponse errorResponse = buildErrorResponse(false,HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error",request.getRequestURI());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse buildErrorResponse(boolean success,int code,String message,String path){
        return ErrorResponse.builder()
        .success(success)
        .code(code)
        .message(message)
        .path(path)
        .timestamp(LocalDateTime.now())
        .build();
    }
    
}
