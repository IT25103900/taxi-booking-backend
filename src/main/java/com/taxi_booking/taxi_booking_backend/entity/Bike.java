package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;

@Entity
public class Bike extends Vehicle {

    private boolean hasHelmet;

    public Bike(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, boolean hasHelmet) {
        super(vehicleId, brand, model, pricePerKm, isAvailable);
        this.hasHelmet = hasHelmet;
    }

    public Bike() {
        super();
    }

    public boolean isHasHelmet() {
        return hasHelmet;
    }
    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike Details: " + brand + " " + model + " | Helmet Provided: " + hasHelmet);
    }

    @Override
    public double calculateMaintenanceCost() {
        return 1500.00;
    }
}