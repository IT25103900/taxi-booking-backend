package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.dto.BookingDto;
import com.taxi_booking.taxi_booking_backend.entity.TaxiBooking;
import com.taxi_booking.taxi_booking_backend.entity.enums.BookingStatus; // NEW IMPORT
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
    public ResponseEntity<TaxiBooking> create(@RequestBody BookingDto dto) {
        return ResponseEntity.ok(bookingService.requestRide(dto));
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<TaxiBooking>> getUserHistory(@PathVariable Long passengerId) {
        return ResponseEntity.ok(bookingService.getHistory(passengerId));
    }

    // Driver Endpoint to get available jobs
    @GetMapping("/available")
    public ResponseEntity<List<TaxiBooking>> getAvailableBookings() {
        return ResponseEntity.ok(bookingService.getAvailableJobs());
    }

    // UPDATE Endpoint
    @PutMapping("/{id}/status")
    public ResponseEntity<TaxiBooking> updateStatus(@PathVariable Long id, @RequestParam BookingStatus status) {
        return ResponseEntity.ok(bookingService.updateStatus(id, status));
    }

    // DELETE Endpoint
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking record permanently purged.");
    }
}