package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.dto.VehicleDto;
import com.taxi_booking.taxi_booking_backend.entity.*;
import com.taxi_booking.taxi_booking_backend.entity.enums.VehicleStatus;
import com.taxi_booking.taxi_booking_backend.entity.enums.DriverStatus;
import com.taxi_booking.taxi_booking_backend.repository.VehicleRepository;
import com.taxi_booking.taxi_booking_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    public Vehicle addVehicle(VehicleDto dto) {
        User user = userRepository.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver profile not found."));

        if (user instanceof Driver) {
            Driver driver = (Driver) user;
            if (driver.getDriverStatus() != DriverStatus.APPROVED) {
                throw new IllegalStateException("Access Denied: Profile must be APPROVED by Admin to register vehicles.");
            }
        } else {
            throw new IllegalArgumentException("Invalid Account Instance.");
        }

        Vehicle vehicle;
        switch (dto.getType().toUpperCase()) {
            case "BIKE": vehicle = new Bike(); break;
            case "THREE_WHEELER": vehicle = new ThreeWheeler(); break;
            case "MINI_CAR": vehicle = new MiniCar(); break;
            case "SEDAN": vehicle = new Sedan(); break;
            case "VAN": vehicle = new Van(); break;
            default: throw new IllegalArgumentException("Unknown type: " + dto.getType());
        }

        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setDriverId(dto.getDriverId());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setStatus(VehicleStatus.AVAILABLE);

        return vehicleRepository.save(vehicle);
    }

    // Update Vehicle Status (CRUD: Update)
    public Vehicle updateVehicleStatus(Long id, VehicleStatus newStatus) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found in the database."));

        vehicle.setStatus(newStatus);
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getVehiclesByDriver(Long driverId) { return vehicleRepository.findByDriverId(driverId); }
    public void removeVehicle(Long id) { vehicleRepository.deleteById(id); }
}