package com.example.demo.flightbooking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight_admin")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String flightNumber;
    public String departurePlace;
    public String arrivalPlace;

    public LocalDateTime departureTime;
    public LocalDateTime arrivalTime;

    public int seatAvailability;
    public double price;

    // ✅ Default constructor (required by JPA)
    public Flight() {}

    // ✅ Full constructor
    public Flight(int id, String flightNumber, String departurePlace, int seatAvailability,
                  LocalDateTime departureTime, LocalDateTime arrivalTime,
                  String arrivalPlace, double price) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departurePlace = departurePlace;
        this.seatAvailability = seatAvailability;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.arrivalPlace = arrivalPlace;
        this.price = price;
    }


    // ✅ Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public int getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(int seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", departurePlace='" + departurePlace + '\'' +
                ", arrivalPlace='" + arrivalPlace + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", seatAvailability=" + seatAvailability +
                ", price=" + price +
                '}';
    }
}
