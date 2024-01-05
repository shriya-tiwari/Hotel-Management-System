package com.example.demo.repository;

import com.example.demo.model.CustomerPhoneNo;
import com.example.demo.model.EmpPhoneNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class EmpPhoneRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmpPhoneRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addEmpPhone(UUID employeeID, String empPhoneNo) {
        String sql = "INSERT INTO emp_phone_no (employeeID, empPhoneNo) VALUES (?,?)";
        return jdbcTemplate.update(sql, employeeID.toString(), empPhoneNo);
    }

    public EmpPhoneNo getEmpPhoneByID(UUID employeeID) {
        String sql = "SELECT * FROM emp_phone_no WHERE employeeID = ?";
        EmpPhoneNo empPhoneNo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(EmpPhoneNo.class), new Object[]{employeeID.toString()});
        return empPhoneNo;
    }

    public int updateEmpPhone(UUID employeeID, String empPhoneNo) {
        String sql = "UPDATE emp_phone_no SET empPhoneNo = ? WHERE employeeID = ?";
        return jdbcTemplate.update(sql, empPhoneNo, employeeID.toString());
    }
}
