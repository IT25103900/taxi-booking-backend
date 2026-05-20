package com.taxi_booking.taxi_booking_backend.repository;

import com.taxi_booking.taxi_booking_backend.entity.TaxiBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<TaxiBooking, Long> {
    List<TaxiBooking> findByPassengerId(Long passengerId);
}