package com.taxi_booking.taxi_booking_backend.entity;

public abstract class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected double pricePerKm;
    protected boolean isAvailable;

    public Vehicle(String vehicleId, String brand, String model, double pricePerKm, boolean isAvailable) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.pricePerKm = pricePerKm;
        this.isAvailable = isAvailable;
    }

    public String getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }
    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract void displayDetails();

    public abstract double calculateMaintenanceCost();
}