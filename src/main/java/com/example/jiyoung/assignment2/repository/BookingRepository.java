package com.example.jiyoung.assignment2.repository;

import com.example.jiyoung.assignment2.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookingRepository implements BookingRepositoryInterface{

    private final EntityManager entityManager;

    @Override
    public List<Booking> getBooking() {
        return entityManager.createQuery("select booking from Booking booking", Booking.class).getResultList();
    }

    @Override
    public String addBooking(Booking booking) {
        entityManager.persist(booking);

        return booking.getBookingNum(); // 예약번호 보내기
    }

    @Override
    public String changeSeat(String bookingNum, String seat) {
        entityManager.createQuery("update Booking set seat=:seat where bookingNum=: bookingNum")
                .setParameter("bookingNum", bookingNum).setParameter("seat",seat).executeUpdate();
        return "좌석이 " + seat + "으로변경되었습니다.";
    }

    @Override
    public String cancelBooking(String bookingNum) {
        entityManager.createQuery("delete from Booking where bookingNum =: bookingNum")
                .setParameter("bookingNum", bookingNum)
                .executeUpdate();

        return "예약이 취소되었습니다.";
    }
}
