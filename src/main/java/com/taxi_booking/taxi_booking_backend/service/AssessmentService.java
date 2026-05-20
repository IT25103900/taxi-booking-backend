package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.dto.AssessmentDto;
import com.taxi_booking.taxi_booking_backend.entity.DriverAssessment;
import com.taxi_booking.taxi_booking_backend.entity.SafetyReport;
import com.taxi_booking.taxi_booking_backend.entity.StandardReview;
import com.taxi_booking.taxi_booking_backend.entity.enums.ReviewStatus;
import com.taxi_booking.taxi_booking_backend.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;


    //CREATE
    public DriverAssessment submitAssessment(AssessmentDto dto)
    {
        DriverAssessment assessment;

        if ("SAFETY".equalsIgnoreCase(dto.getType()))
        {
            SafetyReport report = new SafetyReport();
            report.setViolationType(dto.getViolationType());
            report.setStatus(ReviewStatus.PENDING); // Safety flags go directly to admin moderation
            assessment = report;
        }
        else
        {
            StandardReview review = new StandardReview();
            review.setRating(dto.getRating());

            // Auto-approves perfect 5-star submissions
            if (dto.getRating() == 5)
            {
                review.setStatus(ReviewStatus.APPROVED);
            }
            else
            {
                review.setStatus(ReviewStatus.PENDING);
            }
            assessment = review;
        }

        assessment.setDriverId(dto.getDriverId());
        assessment.setPassengerId(dto.getPassengerId());
        assessment.setComments(dto.getComments());

        return assessmentRepository.save(assessment);
    }


    //READ
    public List<DriverAssessment> viewApprovedRatings(Long driverId)
    {
        return assessmentRepository.findByDriverIdAndStatus(driverId, ReviewStatus.APPROVED);
    }

    public List<DriverAssessment> getAllRecords()
    {
        return assessmentRepository.findAll();
    }


    //UPDATE
    public DriverAssessment updateVisibility(Long id, ReviewStatus status)
    {
        DriverAssessment assessment = assessmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback record missing."));
        assessment.setStatus(status);
        return assessmentRepository.save(assessment);
    }


    //DELETE
    public void purgeFeedback(Long id)
    {
        DriverAssessment assessment = assessmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback record missing."));
        assessmentRepository.delete(assessment);
    }
}