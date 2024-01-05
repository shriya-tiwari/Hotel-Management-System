package com.example.demo.repository;
import com.example.demo.model.EmpEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class EmpEmailRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmpEmailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addEmpEmail(UUID employeeID, String empEmailID) {
        String sql = "INSERT INTO emp_email (employeeID, empEmailID) VALUES (?,?)";
        return jdbcTemplate.update(sql, employeeID.toString(), empEmailID);
    }

    public EmpEmail getEmpEmailByID(UUID employeeID) {
        String sql = "SELECT * FROM emp_email WHERE employeeID = ?";
        EmpEmail empEmail = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(EmpEmail.class), new Object[]{employeeID.toString()});
        return empEmail;
    }

    public int updateEmpEmail(UUID employeeID, String empEmailID) {
        String sql = "UPDATE emp_email SET empEmailID = ? WHERE employeeID = ?";
        return jdbcTemplate.update(sql, empEmailID, employeeID.toString());
    }
}
