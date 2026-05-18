package com.taxi_booking.taxi_booking_backend.entity;

import com.taxi_booking.taxi_booking_backend.entity.enums.FuelType;
import com.taxi_booking.taxi_booking_backend.entity.enums.CarType;

public class Sedan extends Car {
    private double bootSpace;
    private boolean hasSunroof;

    public Sedan(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable, int numberOfSeats, FuelType fuelType, CarType carType, double bootSpace, boolean hasSunroof) {
        super(vehicleId, brand, model, pricePerKm, isAvailable, numberOfSeats, fuelType, carType);
        this.bootSpace = bootSpace;
        this.hasSunroof = hasSunroof;
    }

    public double getBootSpace() {
        return bootSpace;
    }
    public void setBootSpace(double bootSpace) {
        this.bootSpace = bootSpace;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }
    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + vehicleId + " | Brand: " + brand + " | Model: " + model);
        System.out.println("Boot Space: " + bootSpace + "L | Sunroof: " + hasSunroof);
    }

    @Override
    public double calculateMaintenanceCost() {
        return 6500.00;
    }
}