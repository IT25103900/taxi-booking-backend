package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("THREE_WHEELER")
public class ThreeWheeler extends Vehicle {
    @Override
    public int getPassengerCapacity() {
        return 3;
    }
}