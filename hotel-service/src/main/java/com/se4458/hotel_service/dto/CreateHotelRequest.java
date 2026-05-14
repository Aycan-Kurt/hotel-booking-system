package com.se4458.hotel_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateHotelRequest {

    @NotBlank(message = "Hotel name cannot be empty")
    private String name;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotNull(message = "Price per night is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price per night must be greater than 0")
    private Double pricePerNight;

    @NotNull(message = "Rating is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Rating must be greater than 0")
    private Double rating;

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