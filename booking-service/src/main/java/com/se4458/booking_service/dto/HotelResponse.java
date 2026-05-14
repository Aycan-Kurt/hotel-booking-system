package com.se4458.booking_service.dto;

public class HotelResponse {

    private Long id;
    private String name;
    private String city;
    private Double pricePerNight;
    private Double rating;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public Double getRating() {
        return rating;
    }
}
