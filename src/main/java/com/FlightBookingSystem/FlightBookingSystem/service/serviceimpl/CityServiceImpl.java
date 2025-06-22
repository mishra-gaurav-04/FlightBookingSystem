package com.FlightBookingSystem.FlightBookingSystem.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FlightBookingSystem.FlightBookingSystem.dto.request.CityDto;
import com.FlightBookingSystem.FlightBookingSystem.entity.City;
import com.FlightBookingSystem.FlightBookingSystem.repository.CityRepository;
import com.FlightBookingSystem.FlightBookingSystem.service.CityService;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CityDto createCity(CityDto cityDto) {
        City newCity = modelMapper.map(cityDto, City.class);
        newCity = cityRepository.save(newCity);
        return modelMapper.map(newCity,CityDto.class);
    }
    
}
