package com.example.demo.flightbooking.controller;

import com.example.demo.flightbooking.dto.SignupRequest;
import com.example.demo.flightbooking.model.Users1;
import com.example.demo.flightbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody SignupRequest signupRequest) {
        String result = userService.register(signupRequest);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/getallusers")
    public List<Users1> getAllUsers() {
        return userService.getallusers();
    }

    @GetMapping("/email/{email}")
    public Optional<Users1> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/email/{email}")
    public Optional<Users1> deleteByEmail(@PathVariable String email) {
        return userService.deleteuserbyemails(email);
    }
}
