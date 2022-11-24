package com.example.jiyoung.assignment2.service;

import com.example.jiyoung.assignment2.model.Booking;
import com.example.jiyoung.assignment2.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional //데이터 관련
public class BookingService implements BookingServiceInterface{
    private final BookingRepository repository;

    @Autowired
    public BookingService(BookingRepository bookingRepository){
        this.repository=bookingRepository;
    }

    @Override
    public List<Booking> getBooking() {
        return repository.getBooking();
    }

    @Override
    public String addBooking(Booking booking) {
        return repository.addBooking(booking);
    }

    @Override
    public String changeSeat(String bookingNum, String seat) {
        return repository.changeSeat(bookingNum, seat);
    }

    @Override
    public String cancelBooking(String bookingNum) {
        return repository.cancelBooking(bookingNum);
    }
}
