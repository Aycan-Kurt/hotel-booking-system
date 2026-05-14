package com.se4458.booking_service.repository;

import com.se4458.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByHotelIdAndCheckInDateLessThanAndCheckOutDateGreaterThan(
            Long hotelId,
            LocalDate checkOutDate,
            LocalDate checkInDate
    );
}