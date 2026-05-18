package com.dashdrive.backend.entity;

import jakarta.persistence.Entity;

@Entity
public class CardPayment extends Payment {

    @Override
    public Double calculateFinalTotal() {
        return getBaseAmount() + (getBaseAmount() * 0.02);
    }
}