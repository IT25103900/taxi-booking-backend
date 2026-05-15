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

    // Update an existing vehicle in the system
    @PutMapping("/update/{id}")
    public String updateVehicle(@PathVariable String id, @RequestBody Vehicle vehicle) {
        boolean isUpdated = vehicleManager.updateVehicle(id, vehicle);

        // Check if the update was successful
        if (isUpdated) {
            return "Vehicle updated successfully!";
        } else {
            return "Update Failed: Vehicle with ID " + id + " not found!";
        }
    }

    // Delete a vehicle from the system
    @DeleteMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable String id) {
        boolean isDeleted = vehicleManager.deleteVehicle(id);

        // Check if the deletion was successful
        if (isDeleted) {
            return "Vehicle deleted successfully!";
        } else {
            return "Delete Failed: Vehicle with ID " + id + " not found!";
        }
    }
}