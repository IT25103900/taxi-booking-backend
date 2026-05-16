package com.taxi_booking.taxi_booking_backend.entity;

import java.util.Scanner;

public class FeedbackSystem
{
    public static void main(String[] args)
    {
        FeedbackManager manager = new FeedbackManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Taxi Booking Feedback System ---");

        // CREATE
        System.out.print("Enter Feedback ID: ");
        String fid = sc.nextLine();

        System.out.print("Enter Trip ID: ");
        String tid = sc.nextLine();

        System.out.print("Enter Customer ID: ");
        String cid = sc.nextLine();

        System.out.print("Enter Driver ID: ");
        String did = sc.nextLine();

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Rating (1-5): ");
        int rating = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Comment: ");
        String comment = sc.nextLine();

        String[] reasons = {"Polite", "Professional"};

        DriverReview review1 = new DriverReview(fid, tid, cid, did, date, rating, comment, reasons);
        manager.addFeedback(review1);

        Complaint complaint1 = new Complaint("F002", tid, cid, did, date, "Driver was 10 minutes late", "Pending");
        manager.addFeedback(complaint1);


        // READ
        System.out.println("\n--- Current Feedback Records ---");
        for (Feedback f : manager.viewAllFeedbacks())
        {
            f.displayDetails();
        }

        // UPDATE
        System.out.println("\n--- Testing Update Operation ---");
        DriverReview updatedReview = new DriverReview(fid, tid, cid, did, date, 5, "Updated Comment: Excellent!", reasons);
        manager.updateFeedback(updatedReview);


        // DELETE
        System.out.print("\nEnter Feedback ID to delete: ");
        String delId = sc.next();
        manager.deleteFeedback(delId);

        System.out.println("\n--- Final Record Status ---");
        if (manager.viewAllFeedbacks().isEmpty())
        {
            System.out.println("No feedback records available.");
        }
        else
        {
            for (Feedback f : manager.viewAllFeedbacks())
            {
                f.displayDetails();
            }
        }

        System.out.println("\nSystem closed successfully.");
        sc.close();
    }
}