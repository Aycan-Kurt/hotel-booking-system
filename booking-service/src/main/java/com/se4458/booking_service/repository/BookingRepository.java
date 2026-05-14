package com.se4458.booking_service.repository;

import com.se4458.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}