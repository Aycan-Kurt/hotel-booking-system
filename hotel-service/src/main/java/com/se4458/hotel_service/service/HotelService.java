package com.se4458.hotel_service.service;

import com.se4458.hotel_service.dto.CreateHotelRequest;
import com.se4458.hotel_service.model.Hotel;
import com.se4458.hotel_service.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public List<Hotel> searchHotelsByCity(String city) {
        return hotelRepository.findByCityIgnoreCase(city);
    }

    public Hotel getHotelById(Long id) {

        return hotelRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Hotel not found with id: " + id)
                );
    }

    public Hotel createHotel(CreateHotelRequest request) {

        Hotel hotel = new Hotel(
                request.getName(),
                request.getCity(),
                request.getPricePerNight(),
                request.getRating()
        );

        return hotelRepository.save(hotel);
    }
}