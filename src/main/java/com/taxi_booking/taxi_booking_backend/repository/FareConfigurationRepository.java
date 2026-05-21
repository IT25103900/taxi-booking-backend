package com.taxi_booking.taxi_booking_backend.repository;

import com.taxi_booking.taxi_booking_backend.entity.FareConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FareConfigurationRepository extends JpaRepository<FareConfiguration, Long> {
    // Custom query to fetch rates by specific vehicle (e.g., all VAN rates)
    List<FareConfiguration> findByVehicleType(String vehicleType);
}