package com.taxi_booking.taxi_booking_backend.entity;
import java.time.LocalDate;

public abstract class Feedback
{
    private String feedbackId;
    private String tripId;
    private String customerId;
    private String driverId;
    private LocalDate date;;

    public Feedback(String feedbackId, String tripId, String customerId, String driverId, LocalDate date)
    {
        this.feedbackId = feedbackId;
        this.tripId = tripId;
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

    public String getTripId()
    {
        return tripId;
    }
    public void setTripId(String tripId)
    {
        this.tripId = tripId;
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

    public LocalDate getDate()
    {
        return date;
    }
    public void setDate(LocalDate date)
    {
        this.date = date;
    }


    public abstract void displayDetails();

}