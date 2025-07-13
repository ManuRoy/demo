package com.example.demo.flightbooking.service;

import com.example.demo.flightbooking.model.Flight;
import com.example.demo.flightbooking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Flight addflight(Flight flight){
        return flightRepository.save(flight);
    }

    public Flight updateFlight(int id, Flight updatedFlight) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flight.setFlightNumber(updatedFlight.getFlightNumber());
            flight.setDeparturePlace(updatedFlight.getDeparturePlace());
            flight.setDepartureTime(updatedFlight.getDepartureTime());
            flight.setArrivalTime(updatedFlight.getDepartureTime());
            flight.setSeatAvailability(updatedFlight.getSeatAvailability());
            flight.setPrice(updatedFlight.getPrice());
            return flightRepository.save(flight);
        } else {
            throw new RuntimeException("Flight not found with id: " + id);
        }
}
    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> searchFlights(String departurePlace, String arrivalPlace, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        // Correct method name with matching field names
        return flightRepository.findByDeparturePlaceAndArrivalPlaceAndDepartureTimeBetween(
                departurePlace, arrivalPlace, startOfDay, endOfDay
        );
    }

}
