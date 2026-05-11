package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.dto.PaymentInvoiceDto;
import com.taxi_booking.taxi_booking_backend.entity.Payment;
import com.taxi_booking.taxi_booking_backend.entity.PaymentStatus;
import com.taxi_booking.taxi_booking_backend.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // CREATE
    @PostMapping("/invoice")
    public String generateInvoice(@RequestBody PaymentInvoiceDto dto) {
        return paymentService.generateInvoice(dto);
    }

    // READ
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.viewBillingHistory();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Payment updateStatus(
            @PathVariable Long id,
            @RequestParam PaymentStatus status) {

        return paymentService.updatePaymentStatus(id, status);
    }
}