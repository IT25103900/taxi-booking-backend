package com.taxi_booking.taxi_booking_backend.repository;

import com.taxi_booking.taxi_booking_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT d FROM Driver d WHERE d.driverStatus = 'PENDING'")
    List<User> findPendingDrivers();
}