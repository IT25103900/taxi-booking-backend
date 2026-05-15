package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INSTANT")
public class InstantBooking extends Booking {

    @Override
    public boolean validateBookingTime() {
        return true; // Instant rides are always valid right now
    }
}