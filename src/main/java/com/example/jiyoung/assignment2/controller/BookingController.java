package com.example.jiyoung.assignment2.controller;

import com.example.jiyoung.assignment2.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
public class BookingController {
    private final EntityManager entityManager;

    @GetMapping("")
    public List<Booking> getBooking() {
        return entityManager.createQuery("select booking from Booking booking", Booking.class).getResultList();
    }

    @PostMapping("")
    @Transactional
    public String addBooking(@RequestBody final Booking booking) {
        entityManager.persist(booking);
        System.out.println(booking.getBookingNum());
        return booking.getBookingNum(); // 예약번호 보내기
    }

    @PatchMapping("/{bookingNum}/{seat}")
    @Transactional
    public String changeSeat(@PathVariable String bookingNum,@PathVariable String seat) {
        entityManager.createQuery("update Booking set seat=:seat where bookingNum=: bookingNum")
                .setParameter("bookingNum", bookingNum).setParameter("seat",seat).executeUpdate();
        return "좌석이 " + seat + "으로변경되었습니다.";
    }

    @DeleteMapping("/{bookingNum}")
    @Transactional
    public String cancelBooking(@PathVariable("bookingNum") String bookingNum) {
        entityManager.createQuery("delete from Booking where bookingNum =: bookingNum")
                .setParameter("bookingNum", bookingNum)
                .executeUpdate();

        return "예약이 취소되었습니다.";
    }
}
