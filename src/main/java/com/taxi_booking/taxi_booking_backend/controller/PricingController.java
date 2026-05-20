package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
@CrossOrigin(origins = "*")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @GetMapping("/estimate")
    public ResponseEntity<Double> getEstimate(
            @RequestParam String vehicleType,
            @RequestParam Double distance,
            @RequestParam boolean isPeak) {
        return ResponseEntity.ok(pricingService.calculateEstimatedFare(vehicleType, distance, isPeak));
    }
}