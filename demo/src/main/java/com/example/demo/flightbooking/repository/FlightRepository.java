package com.example.demo.flightbooking.repository;

import com.example.demo.flightbooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByDeparturePlaceAndArrivalPlaceAndDepartureTimeBetween(
            String departurePlace, String arrivalPlace,
            LocalDateTime startDateTime, LocalDateTime endDateTime
    );
}
