package com.se4458.hotel_service.service;

import com.se4458.hotel_service.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    public List<Hotel> getAllHotels() {

        List<Hotel> hotels = new ArrayList<>();

        hotels.add(new Hotel(
                1L,
                "Swiss Hotel",
                "Izmir",
                120.0,
                4.5
        ));

        hotels.add(new Hotel(
                2L,
                "Grand Palace",
                "Istanbul",
                200.0,
                4.8
        ));

        hotels.add(new Hotel(
                3L,
                "Blue Sea Resort",
                "Antalya",
                150.0,
                4.3
        ));

        return hotels;
    }
}
