package com.taxi_booking.taxi_booking_backend.entity;

public class Complaint extends Feedback
{

    private String complaintReason;
    private String status;

    public Complaint(String feedbackId, String tripId, String customerId, String driverId,
                     String date, String complaintReason, String status)
    {
        super(feedbackId, tripId, customerId, driverId, date);
        this.complaintReason = complaintReason;
        this.status = status;
    }


    public String getComplaintReason()
    {
        return complaintReason;
    }
    public void setComplaintReason(String reason)
    {
        this.complaintReason = reason;
    }

    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }


    @Override
    public void displayDetails()
    {
        System.out.println("======================================");
        System.out.println("             COMPLAINT         ");
        System.out.println("======================================");
        System.out.println(" Ticket Ref  : " + getFeedbackId());
        System.out.println(" Booking ID  : " + getTripId());
        System.out.println(" Status      : " + status);
        System.out.println("--------------------------------------");
        System.out.println(" Passenger   : " + getCustomerId());
        System.out.println(" Driver      : " + getDriverId());
        System.out.println(" Date        : " + getDate());
        System.out.println("--------------------------------------");
        System.out.println(" Reason      : " + complaintReason);
        System.out.println("======================================\n");
    }
}
