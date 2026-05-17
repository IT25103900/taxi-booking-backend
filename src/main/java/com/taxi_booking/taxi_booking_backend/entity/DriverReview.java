package com.taxi_booking.taxi_booking_backend.entity;

import java.time.LocalDate;

public class DriverReview extends Feedback
{

    private int rating;
    private String comment;
    private String[] suggestedReasons;

    public DriverReview(String feedbackId, String tripId, String customerId, String driverId,
                        LocalDate date, int rating, String comment, String[] suggestedReasons)
    {
        super(feedbackId, tripId, customerId, driverId, date);
        this.rating = rating;
        this.comment = comment;
        this.suggestedReasons = suggestedReasons;
    }

    public int getRating()
    {
        return rating;
    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public String getComment()
    {
        return comment;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String[] getSuggestedReasons()
    {
        return suggestedReasons;
    }
    public void setSuggestedReasons(String[] suggestedReasons)
    {
        this.suggestedReasons = suggestedReasons;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("--- Driver Review ---");
        System.out.println("Feedback ID : " + getFeedbackId());
        System.out.println("Trip ID     : " + getTripId());
        System.out.println("Rating      : " + rating + "/5");
        System.out.println("Comment     : " + comment);

        // Check if the array is empty before printing
        if (suggestedReasons != null)
        {
            System.out.println("Reasons     : " + String.join(", ", suggestedReasons));
        }
        else
        {
            System.out.println("Reasons     : None");
        }

        System.out.println("Date        : " + getDate());
        System.out.println("---------------------");
    }
}