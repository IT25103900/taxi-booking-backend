package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PEAK_SURGE")
public class PeakHourPricing extends FareConfiguration {

    @Override
    public Double computeTotalTripFare(Double distanceKms) {
        // Automatically injects a 1.5x peak-hour multiplier to the final calculation
        return (getBaseFareAmount() + (getRatePerKm() * distanceKms)) * 1.5;
    }
}