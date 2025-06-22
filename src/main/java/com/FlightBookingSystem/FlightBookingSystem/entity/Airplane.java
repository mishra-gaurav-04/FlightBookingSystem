package com.FlightBookingSystem.FlightBookingSystem.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Airplane {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false,unique=true)
    private String airplaneNumber;

    @Column(nullable = false)
    private Long capacity = 0L;

    @OneToOne(mappedBy="airplane")
    private Flight flight;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airplane")
    private Set<Seat> seat;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
}
