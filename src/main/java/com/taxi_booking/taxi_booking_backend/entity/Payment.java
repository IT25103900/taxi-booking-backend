// entity/Payment.java
package com.taxi_booking.taxi_booking_backend.entity;

import com.taxi_booking.taxi_booking_backend.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "payments")
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private double baseAmount;
    private String receiptId;
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    // Constructors
    public Payment() {}

    public Payment(Long bookingId, double baseAmount) {
        this.bookingId = bookingId;
        this.baseAmount = baseAmount;
        this.paymentDate = LocalDateTime.now();
        this.status = PaymentStatus.PENDING;
        this.receiptId = "RCP-" + System.currentTimeMillis();
    }

    // Abstract method — POLYMORPHISM
    public abstract double calculateFinalTotal();

    // Getters & Setters
    public Long getId() { return id; }
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
    public double getBaseAmount() { return baseAmount; }
    public void setBaseAmount(double baseAmount) { this.baseAmount = baseAmount; }
    public String getReceiptId() { return receiptId; }
    public void setReceiptId(String receiptId) { this.receiptId = receiptId; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
}