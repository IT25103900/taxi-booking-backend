package com.taxi_booking.taxi_booking_backend.entity;

import com.taxi_booking.taxi_booking_backend.entity.enums.ReviewStatus;
import java.time.LocalDate;

public class Complaint extends Feedback
{
    private String complaintReason;
    private String severity;

    public Complaint(String feedbackId, String tripId, String customerId, String driverId,
                     LocalDate date, String complaintReason, String severity)
    {
        super(feedbackId, tripId, customerId, driverId, date);
        this.complaintReason = complaintReason;
        this.severity = severity;
    }

    public String getComplaintReason()
    {
        return complaintReason;
    }
    public void setComplaintReason(String complaintReason)
    {
        this.complaintReason = complaintReason;
    }

    public String getSeverity()
    {
        return severity;
    }
    public void setSeverity(String severity)
    {
        this.severity = severity;
    }

    @Override
    public void processAssessment()
    {
        setStatus(ReviewStatus.PENDING);
        System.out.println("COMPLAINT FILED! Driver ID: " + getDriverId() + " flagged with 'Needs Investigation' status.");
        System.out.println("Severity: " + severity + " | Admin review required.");
    }

    @Override
    public void displayDetails()
    {
        System.out.println("--- Complaint Report ---");
        System.out.println("Feedback ID : " + getFeedbackId());
        System.out.println("Trip ID     : " + getTripId());
        System.out.println("Severity    : " + severity);
        System.out.println("Reason      : " + complaintReason);
        System.out.println("Status      : " + getStatus());
        System.out.println("Date        : " + getDate());
        System.out.println("------------------------");
    }
}