package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;

@Entity
public class StandardFare extends PricingModel {

    public StandardFare() {
    }

    public StandardFare(double baseRate, double distanceMultiplier) {
        super(baseRate, distanceMultiplier);
    }

    @Override
    public double calculateTotalFare(double distance, double time) {

        return getBaseRate() + (distance * getDistanceMultiplier()) + (time * 20);
    }
}
