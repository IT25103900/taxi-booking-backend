package com.taxi_booking.taxi_booking_backend.entity;

import java.util.List;

public class FeedbackManager
{

    private List<Feedback> feedbackList;

    // Create
    public void addFeedback(Feedback f)
    {
        feedbackList.add(f);
        System.out.println("Feedback added successfully!");
    }
}