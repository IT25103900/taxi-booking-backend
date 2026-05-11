package com.taxi_booking.taxi_booking_backend.entity;

public class Van extends Vehicle {

    private int numDoors;
    private int passengerCapacity;

    public Van(String vehicleId, String brand, String model, int year, String licensePlate, String status, int numDoors, int passengerCapacity) {
        super(vehicleId, brand, model, year, licensePlate, status);
        this.numDoors = numDoors;
        this.passengerCapacity = passengerCapacity;
    }

    public int getNumDoors() { return numDoors; }
    public void setNumDoors(int numDoors) { this.numDoors = numDoors; }

    public int getPassengerCapacity() { return passengerCapacity; }
    public void setPassengerCapacity(int passengerCapacity) { this.passengerCapacity = passengerCapacity; }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Doors: " + numDoors + ", Capacity: " + passengerCapacity;
    }

    @Override
    public double calculateMaintenanceCost() {
        return 8500.00;
    }
}