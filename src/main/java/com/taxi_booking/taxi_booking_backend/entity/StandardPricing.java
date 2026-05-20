package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STANDARD_RATE")
public class StandardPricing extends FareConfiguration {

    @Override
    public Double computeTotalTripFare(Double distanceKms) {
        return getBaseFareAmount() + (getRatePerKm() * distanceKms);
    }
}
