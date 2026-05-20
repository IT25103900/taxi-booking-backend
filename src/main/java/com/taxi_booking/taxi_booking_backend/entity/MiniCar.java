package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MINI_CAR")
public class MiniCar extends Vehicle {
    @Override
    public int getPassengerCapacity() {
        return 4;
    }

    @Override
    public String getRequiredLicense() {
        return "Class B - Light Motor Vehicle License (Auto/Manual)";
    }
}