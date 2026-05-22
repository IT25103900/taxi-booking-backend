package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PEAK_SURGE")
public class PeakHourPricing extends FareConfiguration {
    @Override
    public Double computeTotalTripFare(Double distanceKms) {
        // Polymorphism: Peak hours multiply the base calculation by 1.5x
        return (getBaseFareAmount() + (getRatePerKm() * distanceKms)) * 1.5;
    }
}