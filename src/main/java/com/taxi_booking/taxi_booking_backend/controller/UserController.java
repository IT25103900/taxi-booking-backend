package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.dto.UserDto;
import com.taxi_booking.taxi_booking_backend.entity.User;
import com.taxi_booking.taxi_booking_backend.entity.enums.DriverStatus;
import com.taxi_booking.taxi_booking_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Lift CORS constraints for the frontend environment
public class UserController {

    @Autowired
    private UserService userService;

    // Fixed Parameter Binding matching query parameters explicitly
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        try {
            User user = userService.loginUser(email, password);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto dto) {
        User savedUser = userService.registerUser(dto);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/admin/pending-drivers")
    public ResponseEntity<List<User>> getPendingDrivers() {
        return ResponseEntity.ok(userService.getPendingDrivers());
    }

    @PutMapping("/{id}/phone")
    public ResponseEntity<User> updateUserProfile(
            @PathVariable Long id,
            @RequestParam String phoneNumber) {
        return ResponseEntity.ok(userService.updateUserProfile(id, phoneNumber));
    }

    @PutMapping("/admin/driver/{id}/status")
    public ResponseEntity<User> updateDriverStatus(
            @PathVariable Long id,
            @RequestParam DriverStatus status) {
        return ResponseEntity.ok(userService.updateDriverStatus(id, status));
    }

    @DeleteMapping("/admin/driver/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable Long id) {
        userService.deleteDriver(id);
        return ResponseEntity.ok("Driver successfully deleted from the system.");
    }

    @GetMapping("/{id}/profile-summary")
    public ResponseEntity<String> getPolymorphicProfileDetails(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user.getProfileDetails());
    }
}