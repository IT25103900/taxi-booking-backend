package com.taxi_booking.taxi_booking_backend.dto;

public class UserDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String role; // "CUSTOMER", "DRIVER", "SUPER_ADMIN"

    // Subclass-specific values
    private String licenseNumber;
    private String adminAccessLevel;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public String getAdminAccessLevel() { return adminAccessLevel; }
    public void setAdminAccessLevel(String adminAccessLevel) { this.adminAccessLevel = adminAccessLevel; }
}