package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

    private int loyaltyPoints;

    @Override
    public String getProfileDetails() {
        return "Customer Profile: " + getName() + " | Loyalty Points: " + loyaltyPoints;
    }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }
}