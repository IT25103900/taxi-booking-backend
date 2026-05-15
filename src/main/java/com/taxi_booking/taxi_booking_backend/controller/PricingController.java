package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.dto.PricingDto;
import com.taxi_booking.taxi_booking_backend.entity.PricingModel;
import com.taxi_booking.taxi_booking_backend.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
@CrossOrigin("*")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @PostMapping("/estimate")
    public double estimateFare(
            @RequestBody PricingDto dto) {

        return pricingService.estimateFare(dto);
    }

    @PostMapping("/create")
    public PricingModel createRate(
            @RequestBody PricingModel pricingModel) {

        return pricingService.createRateTable(pricingModel);
    }

    @PutMapping("/update/{id}")
    public PricingModel updateRate(
            @PathVariable Long id,
            @RequestBody PricingModel pricingModel) {

        return pricingService.updateRate(id, pricingModel);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRate(
            @PathVariable Long id) {

        pricingService.deleteRate(id);

        return "Rate deleted successfully";
    }
}
