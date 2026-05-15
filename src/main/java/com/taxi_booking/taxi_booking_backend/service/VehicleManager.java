package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.entity.Vehicle;
import com.taxi_booking.taxi_booking_backend.exception.VehicleNotFoundException;
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
    public void deleteVehicle(String id) {
        boolean isRemoved = vehicleList.removeIf(vehicle -> vehicle.getVehicleId().equals(id));

        if (!isRemoved) {
            throw new VehicleNotFoundException("Vehicle with ID " + id + " does not exist in the system!");
        } else {
            System.out.println("Vehicle with ID " + id + " deleted successfully.");
        }
    }
}