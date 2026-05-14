package com.se4458.booking_service.service;

import com.se4458.booking_service.dto.CreateBookingRequest;
import com.se4458.booking_service.dto.HotelResponse;
import com.se4458.booking_service.dto.UpdateBookingRequest;
import com.se4458.booking_service.model.Booking;
import com.se4458.booking_service.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RestTemplate restTemplate;

    public BookingService(BookingRepository bookingRepository, RestTemplate restTemplate) {
        this.bookingRepository = bookingRepository;
        this.restTemplate = restTemplate;
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

        String hotelServiceUrl = "http://localhost:8080/api/v1/hotels/" + request.getHotelId();

        HotelResponse hotel = restTemplate.getForObject(
                hotelServiceUrl,
                HotelResponse.class
        );

        if (hotel == null) {
            throw new RuntimeException("Hotel not found");
        }

        List<Booking> conflictingBookings =
                bookingRepository.findByHotelIdAndCheckInDateLessThanAndCheckOutDateGreaterThan(
                        request.getHotelId(),
                        request.getCheckOutDate(),
                        request.getCheckInDate()
                );

        if (!conflictingBookings.isEmpty()) {
            throw new RuntimeException("Hotel is already booked for the selected date range");
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