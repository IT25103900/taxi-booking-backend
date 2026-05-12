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

    public String getFeedbackId()
    {
        return feedbackId;
    }
    public void setFeedbackId(String feedbackId)
    {
        this.feedbackId = feedbackId;
    }

    public String getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }

    public String getDriverId()
    {
        return driverId;
    }
    public void setDriverId(String driverId)
    {
        this.driverId = driverId;
    }

    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }


    public abstract void displayDetails();

}