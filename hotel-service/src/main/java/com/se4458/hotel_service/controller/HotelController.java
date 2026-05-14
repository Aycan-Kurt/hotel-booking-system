package com.se4458.hotel_service.controller;

import com.se4458.hotel_service.model.Hotel;
import com.se4458.hotel_service.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/api/v1/hotels")
    public List<Hotel> getHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/api/v1/hotels/health")
    public String healthCheck() {
        return "Hotel Service is running!";
    }
}