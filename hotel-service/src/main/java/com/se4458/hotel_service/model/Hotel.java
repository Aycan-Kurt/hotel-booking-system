package com.se4458.hotel_service.model;

public class Hotel {

    private Long id;
    private String name;
    private String city;
    private Double pricePerNight;
    private Double rating;

    public Hotel(Long id, String name, String city,
                 Double pricePerNight, Double rating) {

        this.id = id;
        this.name = name;
        this.city = city;
        this.pricePerNight = pricePerNight;
        this.rating = rating;
    }

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