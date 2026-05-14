package com.se4458.hotel_service.controller;

import com.se4458.hotel_service.dto.CreateHotelRequest;
import com.se4458.hotel_service.model.Hotel;
import com.se4458.hotel_service.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/v1/hotels/search")
    public List<Hotel> searchHotels(@RequestParam String city) {
        return hotelService.searchHotelsByCity(city);
    }

    @PostMapping("/api/v1/hotels")
    public Hotel createHotel(@Valid @RequestBody CreateHotelRequest request) {
        return hotelService.createHotel(request);
    }

    @GetMapping("/api/v1/hotels/health")
    public String healthCheck() {
        return "Hotel Service is running!";
    }
}