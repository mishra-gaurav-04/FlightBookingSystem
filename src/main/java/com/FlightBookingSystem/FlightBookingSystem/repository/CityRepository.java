package com.FlightBookingSystem.FlightBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FlightBookingSystem.FlightBookingSystem.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
