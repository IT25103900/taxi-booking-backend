package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.entity.*;
import com.taxi_booking.taxi_booking_backend.repository.FareConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PricingService {

    @Autowired
    private FareConfigurationRepository repository;

    // CRUD: CREATE
    public FareConfiguration createRateTable(FareConfiguration config) {
        return repository.save(config);
    }

    // CRUD: READ ALL
    public List<FareConfiguration> getAllConfigs() {
        return repository.findAll();
    }

    // CRUD: UPDATE
    public FareConfiguration adjustBaseRate(Long id, Double newBase, Double newPerKm) {
        FareConfiguration config = repository.findById(id).orElseThrow();
        if(newBase != null) config.setBaseFareAmount(newBase);
        if(newPerKm != null) config.setRatePerKm(newPerKm);
        return repository.save(config);
    }

    // CRUD: DELETE
    public void deleteRateTable(Long id) {
        repository.deleteById(id);
    }

    // POLYMORPHISM & VEHICLE MAPPING
    public Double calculateEstimatedFare(String vehicleType, Double distance, boolean isPeak) {
        // 1. Fetch DB pricing configurations for the requested vehicle
        List<FareConfiguration> configs = repository.findByVehicleType(vehicleType);
        FareConfiguration config = null;

        // 2. Select the polymorphic instance based on the peak status
        if (isPeak) {
            config = configs.stream().filter(c -> c instanceof PeakHourPricing).findFirst().orElse(null);
        } else {
            config = configs.stream().filter(c -> c instanceof StandardPricing).findFirst().orElse(null);
        }

        // 3. Fallback (If admin hasn't added this vehicle to the DB yet, create an instance in memory so app doesn't crash)
        if (config == null) {
            double fallbackBase = ("VAN".equalsIgnoreCase(vehicleType) || "MINI_CAR".equalsIgnoreCase(vehicleType)) ? 150.0 : 80.0;
            double fallbackPerKm = ("VAN".equalsIgnoreCase(vehicleType) || "MINI_CAR".equalsIgnoreCase(vehicleType)) ? 90.0 : 60.0;

            if (isPeak) {
                PeakHourPricing php = new PeakHourPricing();
                php.setBaseFareAmount(fallbackBase); php.setRatePerKm(fallbackPerKm);
                config = php;
            } else {
                StandardPricing sp = new StandardPricing();
                sp.setBaseFareAmount(fallbackBase); sp.setRatePerKm(fallbackPerKm);
                config = sp;
            }
        }

        // 4. Trigger the overridden calculation
        return Math.round(config.computeTotalTripFare(distance) * 100.0) / 100.0;
    }
}