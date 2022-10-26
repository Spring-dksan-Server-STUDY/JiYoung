package com.example.jiyoung.assignment2.controller;

import com.example.jiyoung.assignment2.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
public class BookingController {
    private final EntityManager entityManager;

    @GetMapping("/")
    public List<Booking> getBooking(){
        return entityManager.createQuery("select booking from Booking booking", Booking.class).getResultList();
    }

    @PostMapping("/add")
    @Transactional
    public String addBooking(@RequestBody final Booking booking){
        entityManager.persist(booking);
        System.out.println(booking.getBookingNum());
        return booking.getBookingNum(); // 예약번호 보내기
    }

    @PatchMapping("/change")
    @Transactional
    public String changeSeat(@RequestBody final Booking booking){
        return booking.getSeat();
    }

    @DeleteMapping("/delete")
    @Transactional
    public String cancelBooking(@RequestBody final Booking booking){
        return "예약이 취소되었습니다.";
    }
}
