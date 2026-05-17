package com.taxi_booking.taxi_booking_backend.entity;

import java.util.ArrayList;
import java.util.List;

public class FeedbackManager
{

    private List<Feedback> feedbackList = new ArrayList<>();

    // CREATE
    public void addFeedback(Feedback f)
    {
        feedbackList.add(f);
        System.out.println("Feedback added successfully!");
    }

    // READ
    public List<Feedback> viewAllFeedbacks()
    {
        return feedbackList;
    }

    // UPDATE
    public void updateFeedback(String id, Feedback updatedFeedback)
    {
        for (int i = 0; i < feedbackList.size(); i++)
        {
            // Check if the current item's ID matches the provided 'id' parameter
            if (feedbackList.get(i).getFeedbackId().equals(id))
            {
                feedbackList.set(i, updatedFeedback);
                System.out.println("Feedback updated successfully!");
                return;
            }
        }
        System.out.println("Feedback not found!");
    }

    // DELETE - remove by ID
    public void deleteFeedback(String id)
    {
        for (int i = 0; i < feedbackList.size(); i++)
        {
            if (feedbackList.get(i).getFeedbackId().equals(id))
            {
                feedbackList.remove(i);
                System.out.println("Feedback " + id + " deleted.");
                return;
            }
        }
        System.out.println("Feedback ID not found!");
    }
}