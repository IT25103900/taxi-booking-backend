package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VAN")
public class Van extends Vehicle {
    @Override
    public int getPassengerCapacity() {
        return 8;
    }

    @Override
    public String getRequiredLicense() {
        return "Class G1 - Light Transport / Passenger Van License Required";
    }
}