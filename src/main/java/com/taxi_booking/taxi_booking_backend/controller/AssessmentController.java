package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.dto.AssessmentDto;
import com.taxi_booking.taxi_booking_backend.entity.DriverAssessment;
import com.taxi_booking.taxi_booking_backend.entity.enums.ReviewStatus;
import com.taxi_booking.taxi_booking_backend.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assessments")
@CrossOrigin(origins = "*")
public class AssessmentController
{

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/submit")
    public ResponseEntity<DriverAssessment> submit(@RequestBody AssessmentDto dto)
    {
        return ResponseEntity.ok(assessmentService.submitAssessment(dto));
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<DriverAssessment>> getDriverRatings(@PathVariable Long driverId)
    {
        return ResponseEntity.ok(assessmentService.viewApprovedRatings(driverId));
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<DriverAssessment>> getAll()
    {
        return ResponseEntity.ok(assessmentService.getAllRecords());
    }

    @PutMapping("/admin/{id}/visibility")
    public ResponseEntity<DriverAssessment> updateVisibility(@PathVariable Long id, @RequestParam ReviewStatus status)
    {
        return ResponseEntity.ok(assessmentService.updateVisibility(id, status));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        assessmentService.purgeFeedback(id);
        return ResponseEntity.ok("Feedback records cleanly purged.");
    }

    //NEW ENDPOINTS FOR CUSTOMER CRUD

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<DriverAssessment>> getPassengerRatings(@PathVariable Long passengerId)
    {
        return ResponseEntity.ok(assessmentService.getPassengerReviews(passengerId));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DriverAssessment> editAssessment(@PathVariable Long id, @RequestBody AssessmentDto dto)
    {
        return ResponseEntity.ok(assessmentService.editReview(id, dto));
    }

    // VIVA DEMO: Executes the polymorphic outcome rule live on screen
    @GetMapping("/{id}/trigger-rule")
    public ResponseEntity<String> testPolymorphism(@PathVariable Long id) {
        DriverAssessment assessment = assessmentService.getAllRecords().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Record not found"));

        // This single line demonstrates pure OOP Polymorphism
        return ResponseEntity.ok(assessment.processAssessment());
    }
}