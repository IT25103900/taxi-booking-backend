package com.taxi_booking.taxi_booking_backend.entity;

public class Bike extends Vehicle {

    private boolean hasHelmet;

    public Bike(String vehicleId, String brand, String model, int year, String licensePlate, String status, boolean hasHelmet) {
        super(vehicleId, brand, model, year, licensePlate, status);
        this.hasHelmet = hasHelmet;
    }

    public boolean isHasHelmet() {
        return hasHelmet;
    }
    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Helmet Provided: " + hasHelmet;
    }

    @Override
    public double calculateMaintenanceCost() {
        return 2000.00;
    }
}