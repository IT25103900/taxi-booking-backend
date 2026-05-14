package com.taxi_booking.taxi_booking_backend.entity;

public class Complaint extends Feedback
{

    private String complaintReason;
    private String status;

    public Complaint(String feedbackId, String tripId, String customerId, String driverId,
                     String date, String complaintReason, String status)
    {
        super(feedbackId, tripId, customerId, driverId, date);
        this.complaintReason = complaintReason;
        this.status = status;
    }
}