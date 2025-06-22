package com.FlightBookingSystem.FlightBookingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FlightBookingSystem.FlightBookingSystem.dto.request.CityDto;
import com.FlightBookingSystem.FlightBookingSystem.service.CityService;
import com.FlightBookingSystem.FlightBookingSystem.utils.common.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityService cityService;

    @PostMapping("/create-city")
    public ResponseEntity<ApiResponse<CityDto>> createCity(@Valid @RequestBody CityDto cityDto){
        CityDto newCity = cityService.createCity(cityDto);
        ApiResponse<CityDto> apiResponse = buildApiResponse(true,HttpStatus.CREATED.value(),"City Created Successfully",newCity);
        return ResponseEntity.ok(apiResponse);
    }

    private <T> ApiResponse<T> buildApiResponse(boolean success,int code,String message,T data){
        return ApiResponse.<T>builder()
        .success(success)
        .code(code)
        .message(message)
        .data(data)
        .build();
    }
    
}
