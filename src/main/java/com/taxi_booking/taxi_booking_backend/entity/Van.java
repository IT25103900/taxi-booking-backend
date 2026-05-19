package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;

@Entity
public class Van extends Vehicle {

    private int payloadCapacity;

    public Van(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, int payloadCapacity) {
        super(vehicleId, brand, model, pricePerKm, isAvailable);
        this.payloadCapacity = payloadCapacity;
    }

    public Van() {
        super();
    }

    public int getPayloadCapacity() {
        return payloadCapacity;
    }
    public void setPayloadCapacity(int payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Van Details: " + brand + " " + model + " | Payload Capacity: " + payloadCapacity + "kg");
    }

    @Override
    public double calculateMaintenanceCost() {
        return 10000.00;
    }
}