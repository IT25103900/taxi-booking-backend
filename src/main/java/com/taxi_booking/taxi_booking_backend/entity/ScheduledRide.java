package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("SCHEDULED")
public class ScheduledRide extends TaxiBooking {

    private LocalDateTime targetWindow;

    @Override
    public int calculateDispatchBufferMinutes() {
        return 30; // Pre-allocation trigger padding
    }

    // Getters and Setters
    public LocalDateTime getTargetWindow() {
        return targetWindow;
    }

    public void setTargetWindow(LocalDateTime targetWindow) {
        this.targetWindow = targetWindow;
    }
}