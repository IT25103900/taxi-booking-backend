package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleManager {

    // Store the vehicles added to the system
    private List<Vehicle> vehicleList;

    public VehicleManager() {
        this.vehicleList = new ArrayList<>();
    }

    // Add a new vehicles to the system
    public void addVehicle(Vehicle v) {
        vehicleList.add(v);
        System.out.println("Vehicle successfully added to the system.");
    }

    // View all vehicles in the system
    public List<Vehicle> getAllVehicles() {
        return vehicleList;
    }

    // Update vehicle details
    public boolean updateVehicle(String id, Vehicle updatedVehicle) {
        for (int i = 0; i < vehicleList.size(); i++) {
            Vehicle currentVehicle = vehicleList.get(i);

            if (currentVehicle.getVehicleId().equals(id)) {
                vehicleList.set(i, updatedVehicle); // Replace the old vehicle with the new one
                System.out.println("Vehicle with ID " + id + " has been successfully updated.");
                return true; // Update successful
            }
        }
        System.out.println("Update Failed: Vehicle with ID " + id + " not found!");
        return false;
    }

    // Remove a vehicle from the system
    public boolean deleteVehicle(String id) {
        for (int i = 0; i < vehicleList.size(); i++) {
            Vehicle currentVehicle = vehicleList.get(i);

            // If the vehicle is found, remove it from the list
            if (currentVehicle.getVehicleId().equals(id)) {
                vehicleList.remove(i);
                System.out.println("Vehicle with ID " + id + " deleted successfully.");
                return true;
            }
        }
        // If the entire list is searched and the vehicle is not found
        System.out.println("Delete Failed: Vehicle with ID " + id + " not found!");
        return false;
    }
}