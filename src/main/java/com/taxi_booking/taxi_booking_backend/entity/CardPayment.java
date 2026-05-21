package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CARD")
public class CardPayment extends Payment {

    @Override
    public Double calculateFinalTotal() {
        // Automatically adds a 2% digital processing surcharge to the final total
        double base = getBaseAmount();
        double surcharge = base * 0.02;
        return base + surcharge;
    }
}