package com.example.jiyoung.assignment2.repository;

import com.example.jiyoung.assignment2.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepositoryInterface {
    List<Booking> getBooking();
    String addBooking(Booking booking);
    String changeSeat(String bookingNum, String seat);
    String cancelBooking(String bookingNum);
}
