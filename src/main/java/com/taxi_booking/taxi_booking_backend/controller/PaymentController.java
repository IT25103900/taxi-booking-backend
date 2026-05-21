package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.dto.PaymentDto;
import com.taxi_booking.taxi_booking_backend.entity.Payment;
import com.taxi_booking.taxi_booking_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/record")
    public ResponseEntity<Payment> recordPayment(@RequestBody PaymentDto dto) {
        return ResponseEntity.ok(paymentService.recordPayment(dto));
    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<Payment>> getBillingHistory(@PathVariable Long customerId) {
        return ResponseEntity.ok(paymentService.viewBillingHistory(customerId));
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PutMapping("/admin/{id}/refund")
    public ResponseEntity<Payment> processRefund(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.processRefund(id));
    }

    @DeleteMapping("/admin/{id}/void")
    public ResponseEntity<String> voidTransaction(@PathVariable Long id) {
        paymentService.voidDuplicateTransaction(id);
        return ResponseEntity.ok("Transaction successfully voided from ledgers.");
    }
}