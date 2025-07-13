package com.example.demo.flightbooking.service;

import com.example.demo.flightbooking.dto.SignupRequest;
import com.example.demo.flightbooking.model.Flight;
import com.example.demo.flightbooking.model.Users1;
import com.example.demo.flightbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return "Email already exists!";
        }

        Users1 user = new Users1();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setRole("USER"); // default role
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
        return "User registered successfully!";
    }

    public List<Users1> getallusers() {
        return userRepository.findAll();
    }

    public Optional<Users1> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<Users1> deleteuserbyemails(String email) {
        return userRepository.deleteByEmail(email);
    }
}
