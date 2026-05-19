package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {

    private int seatingCapacity;
    private boolean hasAC;

    public Car(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, int seatingCapacity, boolean hasAC) {
        super(vehicleId, brand, model, pricePerKm, isAvailable);
        this.seatingCapacity = seatingCapacity;
        this.hasAC = hasAC;
    }

    public Car() {
        super();
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean isHasAC() {
        return hasAC;
    }
    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details: " + brand + " " + model + " | Capacity: " + seatingCapacity + " | AC: " + hasAC);
    }

    @Override
    public double calculateMaintenanceCost() {
        return 5000.00;
    }
}