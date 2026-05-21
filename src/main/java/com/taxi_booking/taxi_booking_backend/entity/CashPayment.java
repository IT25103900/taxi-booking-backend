package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CASH")
public class CashPayment extends Payment {

    @Override
    public Double calculateFinalTotal() {
        // Cash transactions carry no digital surcharge
        return getBaseAmount();
    }
}