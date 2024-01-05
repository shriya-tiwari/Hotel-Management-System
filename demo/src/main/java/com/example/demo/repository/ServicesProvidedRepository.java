package com.example.demo.repository;
import com.example.demo.model.ServicesProvided;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ServicesProvidedRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServicesProvidedRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addServiceToBooking(UUID bookingID, UUID serviceID) {
        String sql = "INSERT INTO services_provided (bookingID, serviceID) VALUES (?,?)";
        try {
            return jdbcTemplate.update(sql, bookingID.toString(), serviceID.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<ServicesProvided> getServicesByBookingID(UUID bookingID) {
        String sql = "SELECT * FROM services_provided WHERE bookingID = ?";
        List<ServicesProvided> sp = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ServicesProvided.class), new Object[]{bookingID.toString()});
        return sp;
    }

    public int deleteServicesProvided(UUID bookingID) {
        String sql = "DELETE FROM services_provided where bookingID = ?";
        try {
            return jdbcTemplate.update(sql, bookingID.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}
