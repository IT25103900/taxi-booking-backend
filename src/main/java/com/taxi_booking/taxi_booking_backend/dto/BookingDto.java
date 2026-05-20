package com.taxi_booking.taxi_booking_backend.dto;

public class BookingDto {
    private Long passengerId;
    private String pickupLocation;
    private String dropoffLocation;
    private Double estimatedFare;
    private String type; // "INSTANT" or "SCHEDULED"
    private String scheduledTimeISO;

    // Getters and Setters
    public Long getPassengerId() { return passengerId; }
    public void setPassengerId(Long passengerId) { this.passengerId = passengerId; }
    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public String getDropoffLocation() { return dropoffLocation; }
    public void setDropoffLocation(String dropoffLocation) { this.dropoffLocation = dropoffLocation; }
    public Double getEstimatedFare() { return estimatedFare; }
    public void setEstimatedFare(Double estimatedFare) { this.estimatedFare = estimatedFare; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getScheduledTimeISO() { return scheduledTimeISO; }
    public void setScheduledTimeISO(String scheduledTimeISO) { this.scheduledTimeISO = scheduledTimeISO; }
}