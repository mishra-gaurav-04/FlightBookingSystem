package com.FlightBookingSystem.FlightBookingSystem.utils.common;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private boolean success;
    private int code;
    private String message;
    private String path;
    private LocalDateTime timestamp;

    public ErrorResponse(boolean success,int code,String message,String path,LocalDateTime timestamp){
        this.success = success;
        this.code = code;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }
}
