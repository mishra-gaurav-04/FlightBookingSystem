package com.FlightBookingSystem.FlightBookingSystem.utils.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;

    public ApiResponse(boolean success,int code,String message,T data){
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
