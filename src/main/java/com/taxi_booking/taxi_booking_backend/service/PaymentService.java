package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.dto.PaymentDto;
import com.taxi_booking.taxi_booking_backend.entity.CardPayment;
import com.taxi_booking.taxi_booking_backend.entity.CashPayment;
import com.taxi_booking.taxi_booking_backend.entity.Payment;
import com.taxi_booking.taxi_booking_backend.entity.enums.PaymentStatus;
import com.taxi_booking.taxi_booking_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // CRUD: CREATE
    public Payment recordPayment(PaymentDto dto) {
        Payment payment;

        // Dynamic Polymorphic Object Construction
        if ("CARD".equalsIgnoreCase(dto.getPaymentMethod())) {
            payment = new CardPayment();
        } else {
            payment = new CashPayment();
        }

        payment.setBookingId(dto.getBookingId());
        payment.setCustomerId(dto.getCustomerId());
        payment.setBaseAmount(dto.getBaseAmount());
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus(PaymentStatus.PAID);

        // Pre-calculating the polymorphic amount before saving it to the database table
        double finalTotal = payment.calculateFinalTotal();
        payment.setBaseAmount(Math.round(finalTotal * 100.0) / 100.0);

        return paymentRepository.save(payment);
    }

    // CRUD: READ
    public List<Payment> viewBillingHistory(Long customerId) {
        return paymentRepository.findByCustomerId(customerId);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // CRUD: UPDATE
    public Payment processRefund(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment record not found."));
        payment.setStatus(PaymentStatus.REFUNDED);
        return paymentRepository.save(payment);
    }

    // CRUD: DELETE
    public void voidDuplicateTransaction(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment record not found."));
        paymentRepository.delete(payment);
    }
}