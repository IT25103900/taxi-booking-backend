package com.taxi_booking.taxi_booking_backend.service;

import com.taxi_booking.taxi_booking_backend.dto.PricingDto;
import com.taxi_booking.taxi_booking_backend.entity.PeakFare;
import com.taxi_booking.taxi_booking_backend.entity.StandardFare;
import com.taxi_booking.taxi_booking_backend.repository.PricingRepository;
import org.springframework.stereotype.Service;

@Service
public class PricingService {

    private final PricingRepository pricingRepository;

    public PricingService(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }

    public double estimateFare(PricingDto dto) {

        PricingModel model;

        if (dto.isPeakHour()) {
            model = new PeakFare(200, 100, 1.5);
        } else {
            model = new StandardFare(200, 100);
        }

        return model.calculateTotalFare(dto.getDistance(), dto.getTime());
    }

    public PricingModel createRateTable(PricingModel model) {
        return pricingRepository.save(model);
    }

    public PricingModel updateRate(Long id, PricingModel updated) {

        PricingModel existing = pricingRepository.findById(id).orElseThrow();

        existing.setBaseRate(updated.getBaseRate());
        existing.setDistanceMultiplier(updated.getDistanceMultiplier());

        return pricingRepository.save(existing);
    }

    public void deleteRate(Long id) {
        pricingRepository.deleteById(id);
    }
}