package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;

@Entity
public class CashPayment extends Payment {

    public CashPayment() {
    }

    public CashPayment(Double amount, Long bookingId) {
        super(amount, bookingId);
    }

    @Override
    public String processPayment() {
        setPaymentStatus(PaymentStatus.PAID);
        return "Cash collected by driver successfully.";
    }
}