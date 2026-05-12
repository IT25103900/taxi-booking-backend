package com.taxi_booking.taxi_booking_backend.entity;

public class Van extends Vehicle {
    private int numberOfSeats;
    private double cargoCapacity;
    private boolean isAirConditioned;

    public Van(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, int numberOfSeats, double cargoCapacity, boolean isAirConditioned) {
        super(vehicleId, brand, model, pricePerKm, isAvailable);
        this.numberOfSeats = numberOfSeats;
        this.cargoCapacity = cargoCapacity;
        this.isAirConditioned = isAirConditioned;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }
    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }
    public void setAirConditioned(boolean airConditioned) {
        this.isAirConditioned = airConditioned;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + vehicleId + " | Brand: " + brand + " | Model: " + model);
        System.out.println("Seats: " + numberOfSeats + " | Cargo: " + cargoCapacity + "kg | AC: " + isAirConditioned);
    }

    @Override
    public double calculateMaintenanceCost() {
        return 8000.00;
    }
}