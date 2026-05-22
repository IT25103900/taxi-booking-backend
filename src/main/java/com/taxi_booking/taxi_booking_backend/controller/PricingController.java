package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.entity.FareConfiguration;
import com.taxi_booking.taxi_booking_backend.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pricing")
@CrossOrigin(origins = "*")
public class PricingController {

    @Autowired private PricingService pricingService;

    @PostMapping("/create")
    public ResponseEntity<FareConfiguration> create(@RequestBody FareConfiguration config) {
        return ResponseEntity.ok(pricingService.createRateTable(config));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FareConfiguration>> getAll() {
        return ResponseEntity.ok(pricingService.getAllConfigs());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FareConfiguration> update(@PathVariable Long id, @RequestParam(required=false) Double newBase, @RequestParam(required=false) Double newPerKm) {
        return ResponseEntity.ok(pricingService.adjustBaseRate(id, newBase, newPerKm));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        pricingService.deleteRateTable(id);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @GetMapping("/estimate")
    public ResponseEntity<Double> getEstimate(@RequestParam String vehicleType, @RequestParam Double distance, @RequestParam boolean isPeak) {
        return ResponseEntity.ok(pricingService.calculateEstimatedFare(vehicleType, distance, isPeak));
    }
}