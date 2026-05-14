package com.se4458.booking_service.controller;

import com.se4458.booking_service.dto.CreateBookingRequest;
import com.se4458.booking_service.model.Booking;
import com.se4458.booking_service.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/api/v1/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/api/v1/bookings")
    public Booking createBooking(@Valid @RequestBody CreateBookingRequest request) {
        return bookingService.createBooking(request);
    }

    @GetMapping("/api/v1/bookings/health")
    public String healthCheck() {
        return "Booking Service is running!";
    }
}