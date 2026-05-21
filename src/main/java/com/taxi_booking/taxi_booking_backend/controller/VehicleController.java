package com.taxi_booking.taxi_booking_backend.controller;
import com.taxi_booking.taxi_booking_backend.entity.enums.VehicleStatus;
import com.taxi_booking.taxi_booking_backend.dto.VehicleDto;
import com.taxi_booking.taxi_booking_backend.entity.Vehicle;
import com.taxi_booking.taxi_booking_backend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto dto) {
        try {
            return ResponseEntity.ok(vehicleService.addVehicle(dto));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<Vehicle>> getDriverVehicles(@PathVariable Long driverId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByDriver(driverId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Vehicle> updateStatus(@PathVariable Long id, @RequestParam VehicleStatus status) {
        return ResponseEntity.ok(vehicleService.updateVehicleStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable Long id) {
        vehicleService.removeVehicle(id);
        return ResponseEntity.ok("Purged.");
    }
}