package com.taxi_booking.taxi_booking_backend.entity;

public class DriverReview extends Feedback
{

    private int rating;
    private String comment;
    private String[] suggestedReasons;

    public DriverReview(String feedbackId, String tripId, String customerId, String driverId, String date, int rating, String comment, String[] suggestedReasons)
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

}