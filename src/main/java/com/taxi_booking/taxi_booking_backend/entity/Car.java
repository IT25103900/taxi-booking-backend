package com.taxi_booking.taxi_booking_backend.entity;

import com.taxi_booking.taxi_booking_backend.enums.FuelType;
import com.taxi_booking.taxi_booking_backend.enums.CarType;

public class Car extends Vehicle {
    private int numberOfSeats;
    private FuelType fuelType;
    private CarType carType;

    public Car(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, int numberOfSeats, FuelType fuelType, CarType carType) {
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

    public FuelType getFuelType() {
        return fuelType;
    }
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarType getCarType() {
        return carType;
    }
    public void setCarType(CarType carType) {
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