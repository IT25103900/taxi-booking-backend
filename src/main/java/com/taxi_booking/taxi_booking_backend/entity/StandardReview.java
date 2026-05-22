package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STANDARD_REVIEW")
public class StandardReview extends DriverAssessment {

    private int rating; // 1 to 5 stars numerical score

    @Override
    public String processAssessment() {
        return "STANDARD_RATING_PROCESSED: Driver core star index updated with a score of: " + rating;
    }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}