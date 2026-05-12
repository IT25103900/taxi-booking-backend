package com.taxi_booking.taxi_booking_backend.entity;

public abstract class Feedback
{
    private String feedbackId;
    private String customerId;
    private String driverId;
    private String date;

    public Feedback(String feedbackId, String customerId, String driverId, String date)
    {
        this.feedbackId = feedbackId;
        this.customerId = customerId;
        this.driverId = driverId;
        this.date = date;
    }
}