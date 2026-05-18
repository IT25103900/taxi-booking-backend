// entity/CardPayment.java
package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "card_payments")
public class CardPayment extends Payment {

    private String cardLastFour;

    public CardPayment() {}

    public CardPayment(Long bookingId, double baseAmount, String cardLastFour) {
        super(bookingId, baseAmount);
        this.cardLastFour = cardLastFour;
    }

    @Override
    public double calculateFinalTotal() {
        // 2% digital processing surcharge — POLYMORPHISM
        return getBaseAmount() * 1.02;
    }

    public String getCardLastFour() { return cardLastFour; }
    public void setCardLastFour(String cardLastFour) { this.cardLastFour = cardLastFour; }
}