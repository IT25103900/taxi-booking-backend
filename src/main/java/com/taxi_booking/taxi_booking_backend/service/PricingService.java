package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.entity.*;
import org.springframework.stereotype.Service;

@Service
public class PricingService {

    public Double calculateEstimatedFare(String vehicleType, Double distance, boolean isPeak) {
        FareConfiguration config;

        // Mocking rates mapped neatly to vehicle subclass configurations
        double base = "VAN".equalsIgnoreCase(vehicleType) ? 150.00 : 80.00;
        double perKm = "VAN".equalsIgnoreCase(vehicleType) ? 90.00 : 60.00;

        if (isPeak) {
            PeakHourPricing php = new PeakHourPricing();
            php.setBaseFareAmount(base); php.setRatePerKm(perKm);
            config = php;
        } else {
            StandardPricing sp = new StandardPricing();
            sp.setBaseFareAmount(base); sp.setRatePerKm(perKm);
            config = sp;
        }

        return Math.round(config.computeTotalTripFare(distance) * 100.0) / 100.0;
    }
}