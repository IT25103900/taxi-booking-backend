package com.dashdrive.backend.entity;

import jakarta.persistence.Entity;

@Entity
public class CashPayment extends Payment {

    @Override
    public Double calculateFinalTotal() {
        return getBaseAmount();
    }
}