package com.FlightBookingSystem.FlightBookingSystem.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String flightNumber;
    
    @OneToOne
    @JoinColumn(name="airplane_id",referencedColumnName="id")
    private Airplane airplane;

    @OneToOne
    @JoinColumn(name="arrival_airport_id",referencedColumnName="id")
    private Airport arrivalAirport;

    @OneToOne
    @JoinColumn(name="departure_airport_id",referencedColumnName="id")
    private Airport departureAirport;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private Double price;

    @Column
    private String boardingGate = null;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
