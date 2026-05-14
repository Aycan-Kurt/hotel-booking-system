package com.se4458.booking_service.controller;

import com.se4458.booking_service.dto.CreateBookingRequest;
import com.se4458.booking_service.dto.UpdateBookingRequest;
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

    @GetMapping("/api/v1/bookings/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/api/v1/bookings")
    public Booking createBooking(@Valid @RequestBody CreateBookingRequest request) {
        return bookingService.createBooking(request);
    }

    @PutMapping("/api/v1/bookings/{id}")
    public Booking updateBooking(
            @PathVariable Long id,
            @Valid @RequestBody UpdateBookingRequest request
    ) {
        return bookingService.updateBooking(id, request);
    }

    @DeleteMapping("/api/v1/bookings/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking deleted successfully";
    }

    @GetMapping("/api/v1/bookings/health")
    public String healthCheck() {
        return "Booking Service is running!";
    }
}