package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SUPER_ADMIN")
public class SuperAdmin extends User {

    private String adminAccessLevel;

    @Override
    public String getProfileDetails() {
        return "Admin Profile: " + getName() + " | Access Level: " + adminAccessLevel;
    }

    public String getAdminAccessLevel() { return adminAccessLevel; }
    public void setAdminAccessLevel(String adminAccessLevel) { this.adminAccessLevel = adminAccessLevel; }
}