package com.taxi_booking.taxi_booking_backend.entity;

import com.taxi_booking.taxi_booking_backend.entity.enums.ReviewStatus;
import java.util.ArrayList;
import java.util.List;

public class FeedbackManager
{

    private List<Feedback> feedbackList = new ArrayList<>();

    // CREATE
    public void submitReview(Feedback f)
    {
        f.processAssessment(); // Run polymorphism rule before adding
        feedbackList.add(f);
        System.out.println("Feedback added successfully!");
    }

    // READ
    public List<Feedback> viewDriverRatings(String driverId)
    {
        List<Feedback> result = new ArrayList<>();
        for (Feedback f : feedbackList)
        {
            if (f.getDriverId().equals(driverId) && f.getStatus() == ReviewStatus.APPROVED)
            {
                result.add(f);
            }
        }
        if (result.isEmpty())
        {
            System.out.println("No approved reviews found for Driver ID: " + driverId);
        }
        return result;
    }

    public List<Feedback> viewAllFeedbacks()
    {
        return feedbackList;
    }

    // UPDATE
    public void updateReviewVisibility(String id, ReviewStatus newStatus)
    {
        for (int i = 0; i < feedbackList.size(); i++)
        {
            // Check if the current item's ID matches the provided 'id' parameter
            if (feedbackList.get(i).getFeedbackId().equals(id))
            {
                feedbackList.get(i).setStatus(newStatus);
                System.out.println("Feedback updated successfully!");
                return;
            }
        }
        System.out.println("Feedback not found!");
    }

    // DELETE - remove by ID
    public void deleteInappropriateReview(String id)
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