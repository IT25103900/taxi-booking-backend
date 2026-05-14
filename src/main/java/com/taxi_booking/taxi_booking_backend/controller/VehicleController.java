package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.entity.Vehicle;
import com.taxi_booking.taxi_booking_backend.service.VehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleManager vehicleManager;

    // Add a new vehicle to the system
    @PostMapping("/add")
    public String addVehicle(@RequestBody Vehicle vehicle) {
        vehicleManager.addVehicle(vehicle);
        return "Vehicle added successfully to the system!";
    }

    // View all vehicles in the system
    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleManager.getAllVehicles();
    }

    // Delete a vehicle from the system
    @DeleteMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable String id) {
        vehicleManager.deleteVehicle(id);
        return "Vehicle deleted successfully!";
    }
}