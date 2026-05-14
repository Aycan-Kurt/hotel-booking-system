package com.se4458.booking_service.service;

import com.se4458.booking_service.dto.CreateBookingRequest;
import com.se4458.booking_service.dto.UpdateBookingRequest;
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

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
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

    public Booking updateBooking(Long id, UpdateBookingRequest request) {
        if (!request.getCheckOutDate().isAfter(request.getCheckInDate())) {
            throw new RuntimeException("Check-out date must be after check-in date");
        }

        Booking booking = getBookingById(id);

        booking.setHotelId(request.getHotelId());
        booking.setGuestName(request.getGuestName());
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}