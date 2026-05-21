package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.dto.UserDto;
import com.taxi_booking.taxi_booking_backend.entity.Customer;
import com.taxi_booking.taxi_booking_backend.entity.Driver;
import com.taxi_booking.taxi_booking_backend.entity.SuperAdmin;
import com.taxi_booking.taxi_booking_backend.entity.User;
import com.taxi_booking.taxi_booking_backend.entity.enums.DriverStatus;
import com.taxi_booking.taxi_booking_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Simple loop validation mechanism - highly readable for your presentation
    public User loginUser(String email, String password) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new RuntimeException("Invalid email or password.");
    }

    // CRUD: CREATE
    public User registerUser(UserDto dto) {
        User newUser;

        switch (dto.getRole().toUpperCase()) {
            case "CUSTOMER":
                Customer customer = new Customer();
                customer.setLoyaltyPoints(0);
                newUser = customer;
                break;
            case "DRIVER":
                Driver driver = new Driver();
                driver.setLicenseNumber(dto.getLicenseNumber());
                driver.setDriverStatus(DriverStatus.PENDING);
                newUser = driver;
                break;
            case "SUPER_ADMIN":
                SuperAdmin admin = new SuperAdmin();
                admin.setAdminAccessLevel(dto.getAdminAccessLevel());
                newUser = admin;
                break;
            default:
                throw new IllegalArgumentException("Invalid User Role provided");
        }

        newUser.setName(dto.getName());
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(dto.getPassword());
        newUser.setPhoneNumber(dto.getPhoneNumber());

        return userRepository.save(newUser);
    }

    // CRUD: READ (Single Profile)
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // CRUD: READ (Dashboard Approval Queues)
    public List<User> getPendingDrivers() {
        return userRepository.findPendingDrivers();
    }

    // CRUD: UPDATE (Profile management)
    public User updateUserProfile(Long userId, String newPhoneNumber) {
        User user = getUserById(userId);
        user.setPhoneNumber(newPhoneNumber);
        return userRepository.save(user);
    }

    // CRUD: UPDATE (State transitions)
    public User updateDriverStatus(Long driverId, DriverStatus newStatus) {
        User user = getUserById(driverId);

        if (user instanceof Driver) {
            Driver driver = (Driver) user;
            driver.setDriverStatus(newStatus);
            return userRepository.save(driver);
        } else {
            throw new IllegalArgumentException("Provided ID does not belong to a Driver.");
        }
    }

    // CRUD: DELETE (Purge accounts)
    public void deleteDriver(Long driverId) {
        User user = getUserById(driverId);
        if (user instanceof Driver) {
            userRepository.delete(user);
        } else {
            throw new IllegalArgumentException("Cannot delete: User is not a driver.");
        }
    }
}