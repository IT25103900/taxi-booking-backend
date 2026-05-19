package com.taxi_booking.taxi_booking_backend.entity;

import com.taxi_booking.taxi_booking_backend.entity.enums.DriverStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("DRIVER")
public class Driver extends User {

    private String licenseNumber;

    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;

    @Override
    public String getProfileDetails() {
        return "Driver Profile: " + getName() + " | License: " + licenseNumber + " | Status: " + driverStatus;
    }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public DriverStatus getDriverStatus() { return driverStatus; }
    public void setDriverStatus(DriverStatus driverStatus) { this.driverStatus = driverStatus; }
}