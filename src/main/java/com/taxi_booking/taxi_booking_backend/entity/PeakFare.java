package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;

@Entity
public class PeakFare extends PricingModel {

    private double surgeMultiplier;

    public PeakFare() {
    }

    public PeakFare(double baseRate,
                    double distanceMultiplier,
                    double surgeMultiplier) {

        super(baseRate, distanceMultiplier);
        this.surgeMultiplier = surgeMultiplier;
    }

    public double getSurgeMultiplier() {
        return surgeMultiplier;
    }

    public void setSurgeMultiplier(double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }

    @Override
    public double calculateTotalFare(double distance, double time) {

        double standardFare =
                getBaseRate() +
                        (distance * getDistanceMultiplier()) +
                        (time * 20);

        return standardFare * surgeMultiplier;
    }
}
