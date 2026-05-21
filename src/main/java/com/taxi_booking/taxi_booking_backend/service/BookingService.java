package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.dto.BookingDto;
import com.taxi_booking.taxi_booking_backend.entity.*;
import com.taxi_booking.taxi_booking_backend.entity.enums.BookingStatus;
import com.taxi_booking.taxi_booking_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // CRUD: UPDATE
    public TaxiBooking updateStatus(Long id, BookingStatus newStatus) {
        TaxiBooking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking record not found."));
        booking.setStatus(newStatus);
        return bookingRepository.save(booking);
    }

    // CRUD: DELETE
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }


    public TaxiBooking requestRide(BookingDto dto) {
        TaxiBooking booking;
        if ("SCHEDULED".equalsIgnoreCase(dto.getType())) {
            ScheduledRide sr = new ScheduledRide();

            String timeStr = dto.getScheduledTimeISO();
            if (timeStr != null) {
                // Defensive parsing mechanism to protect against timezone string formats ('Z')
                if (timeStr.endsWith("Z")) {
                    sr.setTargetWindow(java.time.OffsetDateTime.parse(timeStr).toLocalDateTime());
                } else {
                    sr.setTargetWindow(LocalDateTime.parse(timeStr));
                }
            }

            booking = sr;
        } else {
            booking = new InstantRide();
        }

        booking.setPassengerId(dto.getPassengerId());
        booking.setPickupLocation(dto.getPickupLocation());
        booking.setDropoffLocation(dto.getDropoffLocation());
        booking.setEstimatedFare(dto.getEstimatedFare());
        booking.setOrderTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.REQUESTED);
        booking.setRequestedVehicleType(dto.getRequestedVehicleType());

        return bookingRepository.save(booking);
    }

    // Fetch jobs for the driver job board
    public List<TaxiBooking> getAvailableJobs() {
        return bookingRepository.findByStatus(BookingStatus.REQUESTED);
    }

    public List<TaxiBooking> getHistory(Long passengerId) { return bookingRepository.findByPassengerId(passengerId); }
}