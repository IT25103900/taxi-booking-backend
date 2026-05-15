package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("SCHEDULED")
public class ScheduledBooking extends Booking {

    @Override
    public boolean validateBookingTime() {
        // Scheduled rides must be at least 30 minutes in the future
        return getBookingTime() != null && getBookingTime().isAfter(LocalDateTime.now().plusMinutes(30));
    }
}