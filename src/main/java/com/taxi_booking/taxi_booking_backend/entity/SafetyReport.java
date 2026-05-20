package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SAFETY_REPORT")
public class SafetyReport extends DriverAssessment
{
    private String violationType;

    @Override
    public String processAssessment()
    {
        return "SAFETY_ALERT_TRIGGERED: Driver flagged as 'Needs Investigation' immediately due to: " + violationType;
    }

    public String getViolationType()
    {
        return violationType;
    }
    public void setViolationType(String violationType)
    {
        this.violationType = violationType;
    }
}