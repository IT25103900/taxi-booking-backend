package com.taxi_booking.taxi_booking_backend.entity;

import com.taxi_booking.taxi_booking_backend.entity.enums.ReviewStatus;
import java.time.LocalDate;

public class StandardReview extends DriverAssessment
{

    private int rating;
    private String comment;
    private String[] suggestedReasons;

    public StandardReview(String feedbackId, String tripId, String customerId, String driverId,
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
    public void processAssessment()
    {
        if (this.rating == 5)
        {
            setStatus(ReviewStatus.APPROVED);
            System.out.println("5-Star review auto-approved! Driver rating updated.");
        }
        else
        {
            setStatus(ReviewStatus.PENDING);
            System.out.println("Review set to PENDING for moderation.");
        }
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
        if (suggestedReasons != null && suggestedReasons.length > 0)
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