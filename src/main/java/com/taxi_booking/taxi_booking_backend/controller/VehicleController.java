package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.entity.Vehicle;
import com.taxi_booking.taxi_booking_backend.entity.Car;
import com.taxi_booking.taxi_booking_backend.entity.Sedan;
import com.taxi_booking.taxi_booking_backend.entity.Bike;
import com.taxi_booking.taxi_booking_backend.entity.Van;
import com.taxi_booking.taxi_booking_backend.service.VehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleManager vehicleManager;

    // ADD ENDPOINTS

    // Add a new Car
    @PostMapping("/add/car")
    public String addCar(@RequestBody Car car) {
        vehicleManager.addVehicle(car);
        return "Car added successfully to the system!";
    }

    // Add a new Sedan
    @PostMapping("/add/sedan")
    public String addSedan(@RequestBody Sedan sedan) {
        vehicleManager.addVehicle(sedan);
        return "Sedan added successfully to the system!";
    }

    // Add a new Bike
    @PostMapping("/add/bike")
    public String addBike(@RequestBody Bike bike) {
        vehicleManager.addVehicle(bike);
        return "Bike added successfully to the system!";
    }

    // Add a new Van
    @PostMapping("/add/van")
    public String addVan(@RequestBody Van van) {
        vehicleManager.addVehicle(van);
        return "Van added successfully to the system!";
    }

    // View all vehicles in the system
    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleManager.getAllVehicles();
    }

    // Update an existing vehicle (We will change this in the next commit)
    @PutMapping("/update/{id}")
    public String updateVehicle(@PathVariable String id, @RequestBody Vehicle vehicle) {
        boolean isUpdated = vehicleManager.updateVehicle(id, vehicle);
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
        if (isDeleted) {
            return "Vehicle deleted successfully!";
        } else {
            return "Delete Failed: Vehicle with ID " + id + " not found!";
        }
    }
}