package com.example.demo.repository;
import com.example.demo.model.CustomerEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class CustomerEmailRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerEmailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addCustomerEmail(UUID customerID, String custEmailID) {
        String sql = "INSERT INTO customer_email (customerID, custEmailID) VALUES (?,?)";
        return jdbcTemplate.update(sql, customerID.toString(), custEmailID);
    }

    public CustomerEmail getCustomerEmailByID(UUID customerID) {
        String sql = "SELECT * FROM customer_email WHERE customerID = ?";
        CustomerEmail customerEmail = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(CustomerEmail.class),
                new Object[]{customerID.toString()});
        return customerEmail;
    }

    public int updateCustomerEmail(UUID customerID, String custEmailID) {
        String sql = "UPDATE customer_email SET custEmailID = ? WHERE customerID = ?";
        return jdbcTemplate.update(sql, custEmailID, customerID.toString());
    }

}
