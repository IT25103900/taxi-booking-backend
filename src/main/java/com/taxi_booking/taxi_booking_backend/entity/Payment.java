package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Double amount;

    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private Long bookingId;

    // Constructors
    public Payment() {
    }

    public Payment(Double amount, Long bookingId) {
        this.amount = amount;
        this.bookingId = bookingId;
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    // Abstract Method (Polymorphism)
    public abstract String processPayment();

    // Getters and Setters
    public Long getPaymentId() {
        return paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
}