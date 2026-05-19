package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;

@Entity
public class Sedan extends Car {

    private boolean hasLuxuryInterior;

    public Sedan(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, int seatingCapacity, boolean hasAC, boolean hasLuxuryInterior) {
        super(vehicleId, brand, model, pricePerKm, isAvailable, seatingCapacity, hasAC);
        this.hasLuxuryInterior = hasLuxuryInterior;
    }

    public Sedan() {
        super();
    }

    public boolean isHasLuxuryInterior() {
        return hasLuxuryInterior;
    }
    public void setHasLuxuryInterior(boolean hasLuxuryInterior) {
        this.hasLuxuryInterior = hasLuxuryInterior;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Luxury Interior: " + (hasLuxuryInterior ? "Yes" : "No"));
    }

    @Override
    public double calculateMaintenanceCost() {
        return 7500.00;
    }
}