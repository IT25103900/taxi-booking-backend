package com.taxi_booking.taxi_booking_backend.entity;

public class Bike extends Vehicle {

    private double engineCapacity;
    private boolean hasHelmetStorage;

    // Getters and Setters
    public double getEngineCapacity() {
        return engineCapacity;
    }

    public Bike(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, double engineCapacity, boolean hasHelmetStorage) {
        super(vehicleId, brand, model, pricePerKm, isAvailable);
        this.engineCapacity = engineCapacity;
        this.hasHelmetStorage = hasHelmetStorage;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public boolean hasHelmetStorage() {
        return hasHelmetStorage;
    }

    public void setHasHelmetStorage(boolean hasHelmetStorage) {
        this.hasHelmetStorage = hasHelmetStorage;
    }

    // Override methods from Vehicle class
    @Override
    public void displayDetails() {
        System.out.println("Displaying Bike details...");
    }

    @Override
    public double calculateMaintenanceCost() {
        // Return a default value for now, you can add real calculations later
        return 0.0;
    }
}