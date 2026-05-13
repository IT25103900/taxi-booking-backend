package com.taxi_booking.taxi_booking_backend.entity;

public class DriverReview extends Feedback
{

    private int rating;
    private String comment;
    private String[] suggestedReasons;

    public DriverReview(String feedbackId, String customerId, String driverId, String date, int rating, String comment, String[] suggestedReasons) {
        super(feedbackId, customerId, driverId, date); // Feedback constructor call
        this.rating = rating;
        this.comment = comment;
        this.suggestedReasons = suggestedReasons;
    }
}