package com.example.jiyoung.assignment2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("booking")
public class BookingController {
    private EntityManager em;
}
