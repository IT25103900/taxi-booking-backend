package com.taxi_booking.taxi_booking_backend.entity;

import jakarta.persistence.*;

@Entity
// OOP Inheritance: Single Table Strategy
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_role", discriminatorType = DiscriminatorType.STRING)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // OOP Encapsulation: Private fields accessed via public getters/setters
    private String name;
    private String email;
    private String password;
    private String phoneNumber;


    public String getRole() {
        if (this instanceof Customer) return "CUSTOMER";
        if (this instanceof Driver) return "DRIVER";
        if (this instanceof SuperAdmin) return "SUPER_ADMIN";
        return "UNKNOWN";
    }

    // OOP Polymorphism: Abstract method overridden by subclasses
    public abstract String getProfileDetails();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}