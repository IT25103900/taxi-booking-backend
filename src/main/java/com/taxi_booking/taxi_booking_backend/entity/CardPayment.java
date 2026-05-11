package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;

@Entity
public class CardPayment extends Payment {

    private String cardNumber;

    public CardPayment() {
    }

    public CardPayment(Double amount, Long bookingId, String cardNumber) {
        super(amount, bookingId);
        this.cardNumber = cardNumber;
    }

    @Override
    public String processPayment() {

        if(cardNumber.length() >= 4) {
            setPaymentStatus(PaymentStatus.PAID);
            return "Connected to VISA API. Payment Successful.";
        }

        setPaymentStatus(PaymentStatus.FAILED);
        return "Payment Failed.";
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}