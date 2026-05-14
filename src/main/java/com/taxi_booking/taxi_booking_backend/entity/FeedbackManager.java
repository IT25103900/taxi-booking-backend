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
    public List<Feedback> viewAllFeedbacks()
    {
        return feedbackList;
    }

    // Update
    public void updateFeedback(Feedback updatedFeedback)
    {
        for (int i = 0; i < feedbackList.size(); i++)
        {
            if (feedbackList.get(i).getFeedbackId().equals(updatedFeedback.getFeedbackId()))
            {
                feedbackList.set(i, updatedFeedback);
                System.out.println("Feedback updated successfully!");
            }
        }
        System.out.println("Feedback not found!");
    }

    // Delete
    public void deleteFeedback(String id)
    {
        for (int i = 0; i < feedbackList.size(); i++)
        {
            if (feedbackList.get(i).getFeedbackId().equals(id))
            {
                feedbackList.remove(i);
                System.out.println("Feedback " + id + " deleted.");
                break;
            }
        }
    }
}