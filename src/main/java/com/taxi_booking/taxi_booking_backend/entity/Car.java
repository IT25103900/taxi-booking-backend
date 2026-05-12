package com.taxi_booking.taxi_booking_backend.entity;

public class Car extends Vehicle {
    private int numberOfSeats;
    private String fuelType;
    private String carType;

    public Car(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, int numberOfSeats, String fuelType, String carType) {
        super(vehicleId, brand, model, pricePerKm, isAvailable);
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.carType = carType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + vehicleId + " | Brand: " + brand + " | Model: " + model);
        System.out.println("Seats: " + numberOfSeats + " | Fuel: " + fuelType + " | Type: " + carType);
    }

    @Override
    public double calculateMaintenanceCost() {
        return 5000.00;
    }
}