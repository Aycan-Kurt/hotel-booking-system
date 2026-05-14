package com.se4458.hotel_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @GetMapping("/api/v1/hotels/health")
    public String healthCheck() {
        return "Hotel Service is running!";
    }
}