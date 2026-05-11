package com.taxi_booking.taxi_booking_backend.entity;

public class Sedan extends Vehicle {

    private int passengerCapacity;

    public Sedan(String vehicleId, String brand, String model, int year, String licensePlate, String status, int passengerCapacity) {
        super(vehicleId, brand, model, year, licensePlate, status);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() { return passengerCapacity; }
    public void setPassengerCapacity(int passengerCapacity) { this.passengerCapacity = passengerCapacity; }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Capacity: " + passengerCapacity;
    }

    @Override
    public double calculateMaintenanceCost() {
        return 5000.00;
    }
}