package com.example.jiyoung.assignment2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //예약한 사람의 이름

    @Column(name="booking_num")
    private String bookingNum; //예약 번호

    private String seat; //좌석 번호

    public Booking(Long id, String name, String bookingNum, String seat){
        this.id=id;
        this.name=name;
        this.bookingNum=bookingNum;
        this.seat=seat;
    }

    public Booking() {

    }
}
