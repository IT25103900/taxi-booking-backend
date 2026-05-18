// entity/CashPayment.java
package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cash_payments")
public class CashPayment extends Payment {

    public CashPayment() {}

    public CashPayment(Long bookingId, double baseAmount) {
        super(bookingId, baseAmount);
    }

    @Override
    public double calculateFinalTotal() {
        // No surcharge for cash
        return getBaseAmount();
    }
}