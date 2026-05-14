package com.se4458.booking_service.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hotelId;

    private String guestName;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    public Booking() {
    }

    public Booking(
            Long hotelId,
            String guestName,
            LocalDate checkInDate,
            LocalDate checkOutDate
    ) {

        this.hotelId = hotelId;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Long getId() {
        return id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public String getGuestName() {
        return guestName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
