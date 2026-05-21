package com.taxi_booking.taxi_booking_backend.repository;

import com.taxi_booking.taxi_booking_backend.entity.DriverAssessment;
import com.taxi_booking.taxi_booking_backend.entity.enums.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<DriverAssessment, Long>
{
    List<DriverAssessment> findByDriverIdAndStatus(Long driverId, ReviewStatus status);

    // Fetch all reviews submitted by a specific customer
    List<DriverAssessment> findByPassengerId(Long passengerId);
}