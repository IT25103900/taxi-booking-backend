package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.dto.PaymentInvoiceDto;
import com.taxi_booking.taxi_booking_backend.entity.*;
import com.taxi_booking.taxi_booking_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // CREATE
    public String generateInvoice(PaymentInvoiceDto dto) {

        Payment payment;

        if(dto.getPaymentType().equalsIgnoreCase("CARD")) {

            payment = new CardPayment(
                    dto.getAmount(),
                    dto.getBookingId(),
                    dto.getCardNumber()
            );

        } else {

            payment = new CashPayment(
                    dto.getAmount(),
                    dto.getBookingId()
            );
        }

        String result = payment.processPayment();

        paymentRepository.save(payment);

        return result;
    }

    // READ
    public List<Payment> viewBillingHistory() {
        return paymentRepository.findAll();
    }

    // UPDATE
    public Payment updatePaymentStatus(Long id, PaymentStatus status) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setPaymentStatus(status);

        return paymentRepository.save(payment);
    }
}