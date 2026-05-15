package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PricingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double baseRate;
    private double distanceMultiplier;

    public PricingModel() {
    }

    public PricingModel(double baseRate, double distanceMultiplier) {
        this.baseRate = baseRate;
        this.distanceMultiplier = distanceMultiplier;
    }

    public Long getId() {
        return id;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public double getDistanceMultiplier() {
        return distanceMultiplier;
    }

    public void setDistanceMultiplier(double distanceMultiplier) {
        this.distanceMultiplier = distanceMultiplier;
    }

    public abstract double calculateTotalFare(double distance, double time);
}