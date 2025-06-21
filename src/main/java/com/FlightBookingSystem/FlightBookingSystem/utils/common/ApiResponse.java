package com.FlightBookingSystem.FlightBookingSystem.utils.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private boolean success;
    private int status;
    private String message;
    private T data;

    public ApiResponse(boolean success,int status,String message,T data){
        this.success = success;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
