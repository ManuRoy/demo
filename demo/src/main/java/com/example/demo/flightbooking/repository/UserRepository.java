package com.example.demo.flightbooking.repository;

import com.example.demo.flightbooking.model.Users1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users1, Long> {
    boolean existsByEmail(String email);
    Optional<Users1> findByEmail(String email);
    Optional<Users1> deleteByEmail(String email);
}
