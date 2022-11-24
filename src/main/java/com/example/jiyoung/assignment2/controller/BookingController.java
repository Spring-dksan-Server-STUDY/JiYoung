package com.example.jiyoung.assignment2.controller;

import com.example.jiyoung.assignment2.model.Booking;
import com.example.jiyoung.assignment2.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("")
    public List<Booking> getBooking() {
        return bookingService.getBooking();
    }

    @PostMapping("")
    @Transactional
    public String addBooking(@RequestBody final Booking booking) {
        return bookingService.addBooking(booking);
    }

    @PatchMapping("/{bookingNum}/{seat}")
    @Transactional
    public String changeSeat(@PathVariable String bookingNum,@PathVariable String seat) {
        return bookingService.changeSeat(bookingNum, seat);
    }

    @DeleteMapping("/{bookingNum}")
    @Transactional
    public String cancelBooking(@PathVariable("bookingNum") String bookingNum) {
       return bookingService.cancelBooking(bookingNum);
    }
}
