package com.example.jiyoung.assignment2.service;

import com.example.jiyoung.assignment2.model.Booking;

import java.util.List;

public interface BookingServiceInterface {
    List<Booking> getBooking();
    String addBooking(Booking booking);
    String changeSeat(String bookingNum, String seat);
    String cancelBooking(String bookingNum);
}
