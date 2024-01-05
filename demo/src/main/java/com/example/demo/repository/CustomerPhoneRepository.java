package com.example.demo.repository;
import com.example.demo.model.CustomerPhoneNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class CustomerPhoneRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerPhoneRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addCustomerPhone(UUID customerID, String custPhoneNo) {
        String sql = "INSERT INTO customer_phone_no (customerID, custPhoneNo) VALUES (?,?)";
        return jdbcTemplate.update(sql, customerID.toString(), custPhoneNo);
    }

    public CustomerPhoneNo getCustomerPhoneByID(UUID customerID) {
        String sql = "SELECT * FROM customer_phone_no WHERE customerID = ?";
        CustomerPhoneNo customerPhoneNo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(CustomerPhoneNo.class), new Object[]{customerID.toString()});
        return customerPhoneNo;
    }

    public int updateCustomerPhone(UUID customerID, String custPhoneNo) {
        String sql = "UPDATE customer_phone_no SET custPhoneNo = ? WHERE customerID = ?";
        return jdbcTemplate.update(sql, custPhoneNo, customerID.toString());
    }
}
