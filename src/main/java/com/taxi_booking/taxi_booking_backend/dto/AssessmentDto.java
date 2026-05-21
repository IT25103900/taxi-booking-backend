package com.taxi_booking.taxi_booking_backend.dto;

public class AssessmentDto
{
    private Long driverId;
    private Long passengerId;
    private String comments;
    private String type; // "STANDARD" or "SAFETY"

    private int rating;
    private String violationType;

    public Long getDriverId()
    {
        return driverId;
    }
    public void setDriverId(Long driverId)
    {
        this.driverId = driverId;
    }

    public Long getPassengerId()
    {
        return passengerId;
    }
    public void setPassengerId(Long passengerId)
    {
        this.passengerId = passengerId;
    }

    public String getComments()
    {
        return comments;
    }
    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public int getRating()
    {
        return rating;
    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public String getViolationType()
    {
        return violationType;
    }
    public void setViolationType(String violationType)
    {
        this.violationType = violationType;
    }
}