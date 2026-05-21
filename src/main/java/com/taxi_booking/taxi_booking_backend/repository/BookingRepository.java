package com.taxi_booking.taxi_booking_backend.repository;

import com.taxi_booking.taxi_booking_backend.entity.TaxiBooking;
import com.taxi_booking.taxi_booking_backend.entity.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<TaxiBooking, Long> {
    List<TaxiBooking> findByPassengerId(Long passengerId);

    // NEW: Fetch all jobs matching a specific status (e.g., REQUESTED)
    List<TaxiBooking> findByStatus(BookingStatus status);
}