package com.se4458.booking_service.service;

import com.se4458.booking_service.dto.CreateBookingRequest;
import com.se4458.booking_service.model.Booking;
import com.se4458.booking_service.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(CreateBookingRequest request) {

        if (!request.getCheckOutDate().isAfter(request.getCheckInDate())) {
            throw new RuntimeException("Check-out date must be after check-in date");
        }

        Booking booking = new Booking(
                request.getHotelId(),
                request.getGuestName(),
                request.getCheckInDate(),
                request.getCheckOutDate()
        );

        return bookingRepository.save(booking);
    }
}