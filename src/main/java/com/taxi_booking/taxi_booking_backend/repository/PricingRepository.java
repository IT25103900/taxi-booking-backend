package com.taxi_booking.taxi_booking_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepository extends JpaRepository<PricingModel, Long> {
    PricingModel findByBaseRate(double baseRate);
}