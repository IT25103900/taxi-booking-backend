package com.taxi_booking.taxi_booking_backend.entity;

public class DriverReview extends Feedback
{

    private int rating;
    private String comment;
    private String[] suggestedReasons;

    public DriverReview(String feedbackId, String tripId, String customerId, String driverId,
                        String date, int rating, String comment, String[] suggestedReasons)
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

        System.out.println("ID: " + getFeedbackId() + " | Trip ID: " + getTripId() + " | Rating: " + rating + "/5");
        System.out.println("Comment: " + comment);

        System.out.print("Reasons: ");
        for (String reason : suggestedReasons)
        {
            System.out.print(reason + " ");
        }

        System.out.println("\n--------------------");
    }
}