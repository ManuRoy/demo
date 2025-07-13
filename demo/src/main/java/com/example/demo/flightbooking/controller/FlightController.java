package com.example.demo.flightbooking.controller;

import com.example.demo.flightbooking.model.Flight;
import com.example.demo.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class FlightController {
    @Autowired
    public FlightService flightService;

    @PostMapping("/admin/flights")
    public ResponseEntity<?> addFlight(@RequestBody Flight flight, @RequestParam String role) {
        if (!role.equalsIgnoreCase("ADMIN")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied: Only admin can add flights.");
        }
        return ResponseEntity.ok(flightService.addflight(flight));
    }

    @PutMapping("/admin/flights/{id}")
    public Flight updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }
    @DeleteMapping("admin/flights/{id}")
    public String deleteFlight(@PathVariable int id){
        flightService.deleteFlight(id);
        return "Flight with id " + id + " deleted successfully.";
    }

    @GetMapping("/flights")
    public List<Flight> getallflights(){
        return flightService.getAllFlights();
    }
    @GetMapping("/flights/search")
    public List<Flight> searchFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date // Format: yyyy-MM-dd
    ) {
        LocalDate localDate = LocalDate.parse(date);
        return flightService.searchFlights(from, to, localDate);
    }

}
