package com.example.demo.repository;
import com.example.demo.model.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ServiceRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addService(UUID serviceID, String name, int cost, String description) {
        String sql = "INSERT INTO service (serviceID, name, cost, description) VALUES (?,?,?,?)";
        try {
            return jdbcTemplate.update(sql, serviceID.toString(), name, cost, description);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Services getServiceByID(UUID serviceID) {
        String sql = "SELECT * FROM service WHERE serviceID = ?";
        Services service = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Services.class), new Object[]{serviceID.toString()});
        return service;
    }

    public int updateServiceCost(UUID serviceID, int cost) {
        String sql = "UPDATE service SET cost = ? WHERE serviceID = ?";
        return jdbcTemplate.update(sql, cost, serviceID.toString());
    }

    public Services getServiceByName(String name) {
        String sql = "SELECT * FROM service WHERE name = ?";
        Services service = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Services.class), new Object[]{name});
        return service;
    }


}
