package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SEDAN")
public class Sedan extends Vehicle {
    @Override
    public int getPassengerCapacity() {
        return 4;
    }

    @Override
    public String getRequiredLicense() {
        return "Class B - Dual Purpose / Motor Car License Required";
    }
}