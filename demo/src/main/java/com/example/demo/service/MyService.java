package com.example.demo.service;

import com.example.demo.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Map;

@Service
public class MyService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MyService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void fetchData() {
        String id = "c017adf4-cf15-40bd-82fa-39505e5ce4c6";
        Booking result = jdbcTemplate.queryForObject("SELECT * FROM booking WHERE bookingID = ?", new BeanPropertyRowMapper<>(Booking.class), id);
        System.out.println(result.getBookingID());
        System.out.println(result.getCheckInDate());
        System.out.println(result.getCheckOutDate());
        System.out.println(result.getNoOfGuests());
    }
}
