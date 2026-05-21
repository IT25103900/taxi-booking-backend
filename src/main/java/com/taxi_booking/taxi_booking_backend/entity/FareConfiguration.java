package com.taxi_booking.taxi_booking_backend.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// FIXED: Changed from rate_type to rate_strategy to match your MySQL database!
@DiscriminatorColumn(name = "rate_strategy")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StandardPricing.class, name = "STANDARD_RATE"),
        @JsonSubTypes.Type(value = PeakHourPricing.class, name = "PEAK_SURGE")
})
public abstract class FareConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String vehicleType;
    private Double baseFareAmount;
    private Double ratePerKm;

    public abstract Double computeTotalTripFare(Double distanceKms);

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public Double getBaseFareAmount() { return baseFareAmount; }
    public void setBaseFareAmount(Double baseFareAmount) { this.baseFareAmount = baseFareAmount; }
    public Double getRatePerKm() { return ratePerKm; }
    public void setRatePerKm(Double ratePerKm) { this.ratePerKm = ratePerKm; }
}