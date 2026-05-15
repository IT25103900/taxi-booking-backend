package com.taxi_booking.taxi_booking_backend.service;


import com.taxi_booking.taxi_booking_backend.dto.PricingDto;
import com.taxi_booking.taxi_booking_backend.entity.PeakFare;
import com.taxi_booking.taxi_booking_backend.entity.PricingModel;
import com.taxi_booking.taxi_booking_backend.entity.StandardFare;
import com.taxi_booking.taxi_booking_backend.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingService {

    @Autowired
    private PricingRepository pricingRepository;

    public double estimateFare(PricingDto dto) {

        PricingModel pricingModel;

        if (dto.isPeakHour()) {

            pricingModel = new PeakFare(
                    200,
                    100,
                    1.5
            );

        } else {

            pricingModel = new StandardFare(
                    200,
                    100
            );
        }

        return pricingModel.calculateTotalFare(
                dto.getDistance(),
                dto.getTime()
        );
    }

    public PricingModel createRateTable(PricingModel pricingModel) {

        return pricingRepository.save(pricingModel);
    }

    public PricingModel updateRate(Long id, PricingModel updatedPricing) {

        PricingModel pricing =
                pricingRepository.findById(id).orElseThrow();

        pricing.setBaseRate(updatedPricing.getBaseRate());

        pricing.setDistanceMultiplier(
                updatedPricing.getDistanceMultiplier()
        );

        return pricingRepository.save(pricing);
    }

    public void deleteRate(Long id) {

        pricingRepository.deleteById(id);
    }
}
