package com.taxi_booking.taxi_booking_backend.entity;

public abstract class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private int year;
    private String licensePlate;
    private String status;

    Vehicle(String vehicleId, String brand, String model, int year, String licensePlate, String status){
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.status = status;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDetails() {
        return "ID: " + vehicleId + ", Brand: " + brand + ", Model: " + model +
                ", Year: " + year + ", Plate: " + licensePlate + ", Status: " + status;
    }

    public abstract double calculateMaintenanceCost();

    public String toFileString() {
        return vehicleId + "," + brand + "," + model + "," + year + "," + licensePlate + "," + status;
    }
}
