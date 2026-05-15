package com.taxi_booking.taxi_booking_backend.dto;

import java.time.LocalDateTime;

public class BookingDto {
    private Long customerId;
    private String pickupLocation;
    private String dropoffLocation;
    private String type; // "INSTANT" or "SCHEDULED"
    private LocalDateTime bookingTime;

    // --- NEW FIELDS ---
    private Double distanceKm;
    private String requestedVehicleType;
    private Double estimatedFare;

    // Getters and Setters
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

    public String getDropoffLocation() { return dropoffLocation; }
    public void setDropoffLocation(String dropoffLocation) { this.dropoffLocation = dropoffLocation; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }

    public Double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(Double distanceKm) { this.distanceKm = distanceKm; }

    public String getRequestedVehicleType() { return requestedVehicleType; }
    public void setRequestedVehicleType(String requestedVehicleType) { this.requestedVehicleType = requestedVehicleType; }

    public Double getEstimatedFare() { return estimatedFare; }
    public void setEstimatedFare(Double estimatedFare) { this.estimatedFare = estimatedFare; }
}