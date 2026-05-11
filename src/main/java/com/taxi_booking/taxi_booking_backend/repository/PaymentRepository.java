package com.taxi_booking.taxi_booking_backend.repository;

import com.taxi_booking.taxi_booking_backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
