package com.taxi_booking.taxi_booking_backend.entity;

public class Car extends Vehicle{
    private int numDoors;
    private String fuelType;

    public Car(String vehicleId, String brand, String model, int year, String licensePlate, String status, int numDoors, String fuelType) {
        super(vehicleId, brand, model, year, licensePlate, status);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Doors: " + numDoors + ", Fuel Type: " + fuelType;
    }

    @Override
    public double calculateMaintenanceCost() {
        return 4500.00;
    }
}
