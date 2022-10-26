package com.example.jiyoung.assignment2;

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
        return entityManager.createQuery("select bookingInfo from Booking bookingInfo", Booking.class).getResultList();
    }

    @PostMapping("/add")
    @Transactional
    public String addBooking(@RequestBody final Booking bookingInfo){
        entityManager.persist(bookingInfo);
        System.out.println(bookingInfo.getBookingNum());
        return bookingInfo.getBookingNum(); // 예약번호 보내기
    }
}
