package com.taxi_booking.taxi_booking_backend.entity;

import java.util.ArrayList;
import java.util.List;

public class FeedbackManager
{

    private List<Feedback> feedbackList = new ArrayList<>();

    // Create
    public void addFeedback(Feedback f)
    {
        feedbackList.add(f);
        System.out.println("Feedback added successfully!");
    }

    // Read
    public void viewAllFeedbacks()
    {
        System.out.println("All Feedbacks: " + feedbackList);
    }
}