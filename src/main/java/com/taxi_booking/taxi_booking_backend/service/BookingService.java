package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.dto.BookingDto;
import com.taxi_booking.taxi_booking_backend.entity.Booking;
import com.taxi_booking.taxi_booking_backend.entity.InstantBooking;
import com.taxi_booking.taxi_booking_backend.entity.ScheduledBooking;
import com.taxi_booking.taxi_booking_backend.entity.enums.BookingStatus;
import com.taxi_booking.taxi_booking_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // CREATE
    public Booking requestRide(BookingDto dto) {
        Booking newBooking;

        if ("SCHEDULED".equalsIgnoreCase(dto.getType())) {
            newBooking = new ScheduledBooking();
            newBooking.setBookingTime(dto.getBookingTime());
        } else {
            newBooking = new InstantBooking();
            newBooking.setBookingTime(LocalDateTime.now());
        }

        newBooking.setCustomerId(dto.getCustomerId());
        newBooking.setPickupLocation(dto.getPickupLocation());
        newBooking.setDropoffLocation(dto.getDropoffLocation());

        // Map new fields
        newBooking.setDistanceKm(dto.getDistanceKm());
        newBooking.setRequestedVehicleType(dto.getRequestedVehicleType());
        newBooking.setEstimatedFare(dto.getEstimatedFare());

        newBooking.setStatus(BookingStatus.PENDING);

        if (!newBooking.validateBookingTime()) {
            throw new IllegalArgumentException("Invalid booking time! Scheduled rides must be at least 30 mins in the future.");
        }

        return bookingRepository.save(newBooking);
    }

    // READ
    public List<Booking> viewBookingHistory(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    // UPDATE
    public Booking changeRideStatus(Long bookingId, BookingStatus newStatus) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setStatus(newStatus);
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found");
    }

    // DELETE
    public void deleteScheduledBooking(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            if (booking instanceof ScheduledBooking && booking.getStatus() == BookingStatus.PENDING) {
                bookingRepository.delete(booking);
            } else {
                throw new IllegalStateException("Can only delete pending scheduled bookings.");
            }
        } else {
            throw new RuntimeException("Booking not found");
        }
    }
}