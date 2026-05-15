package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.dto.BookingDto;
import com.taxi_booking.taxi_booking_backend.entity.Booking;
import com.taxi_booking.taxi_booking_backend.entity.enums.BookingStatus;
import com.taxi_booking.taxi_booking_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/request")
    public ResponseEntity<Booking> requestRide(@RequestBody BookingDto bookingDto) {
        Booking createdBooking = bookingService.requestRide(bookingDto);
        return ResponseEntity.ok(createdBooking);
    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<Booking>> viewBookingHistory(@PathVariable Long customerId) {
        List<Booking> history = bookingService.viewBookingHistory(customerId);
        return ResponseEntity.ok(history);
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<Booking> changeRideStatus(
            @PathVariable Long bookingId,
            @RequestParam BookingStatus status) {
        Booking updatedBooking = bookingService.changeRideStatus(bookingId, status);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{bookingId}/cancel-scheduled")
    public ResponseEntity<String> deleteScheduledBooking(@PathVariable Long bookingId) {
        bookingService.deleteScheduledBooking(bookingId);
        return ResponseEntity.ok("Scheduled booking successfully deleted.");
    }
}