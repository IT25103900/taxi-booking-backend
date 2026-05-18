package com.taxi_booking.taxi_booking_backend.controller;

import com.taxi_booking.taxi_booking_backend.dto.PricingDto;
import com.taxi_booking.taxi_booking_backend.entity.PricingModel;
import com.taxi_booking.taxi_booking_backend.service.PricingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
@CrossOrigin(origins = "*")
public class PricingController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping("/estimate-fare")
    public double getFareEstimate(@RequestBody PricingDto request) {
        // Validate distance input
        if (request.getDistance() <= 0) {
            throw new RuntimeException("Invalid distance");
        }

        return pricingService.estimateFare(request);
    }

    @PostMapping("/add-rate")
    public PricingModel addPricing(@RequestBody PricingModel model) {

        return pricingService.createRateTable(model);
    }

    @PutMapping("/modify/{id}")
    public PricingModel modifyPricing(@PathVariable Long id,
                                      @RequestBody PricingModel model) {
        return pricingService.updateRate(id, model);
    }

    @DeleteMapping("/remove/{id}")
    public String removePricing(@PathVariable Long id) {
        pricingService.deleteRate(id);
        return "Pricing rule removed successfully";
    }
}