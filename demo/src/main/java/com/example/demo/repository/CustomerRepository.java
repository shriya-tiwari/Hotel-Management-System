package com.example.demo.repository;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int registerCustomer(UUID customerID, String fName, String lName, String houseNo, String state, String city, String country, String pinCode, String gender, String aadhaarNo, String password, String pEmail) {
        String sql = "INSERT INTO Customer(customerID, fName, lName, houseNo, state, city, country, pinCode, gender, aadhaarNo, password, pEmail) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            return jdbcTemplate.update(sql, customerID.toString(), fName, lName, houseNo, state, city, country, pinCode, gender, aadhaarNo, password, pEmail);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Customer getCustomerById(UUID customerID) {
        String sql = "SELECT * FROM customer WHERE customerID = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), new Object[]{customerID.toString()});
        return customer;
    }

    public Customer getCustomerByEmail(String pEmail) {
        String sql = "SELECT * FROM customer WHERE pEmail = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), new Object[]{pEmail});
        return customer;
    }

    public int updateCustomerAttribute(UUID customerID, String attributeName, String attributeValue) {
        String sql = "UPDATE customer SET " + attributeName + " = ? WHERE customerID = ?";
        return jdbcTemplate.update(sql, attributeValue, customerID.toString());
    }

    public void deleteCustomer(UUID customerID){
        String sql = "DELETE FROM customer where customerID = ?";
        jdbcTemplate.update(sql, customerID.toString());
    }

    public boolean customerExist(String pEmail) {
        String sql = "Select * from customer where pEmail = ?";
        try{
            Customer customer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), new Object[]{pEmail});
            System.out.println(customer.getCustomerID());
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public void removeCustomer(String pEmail) {
        String sql = "DELETE FROM Customer WHERE pEmail = ?;";
        jdbcTemplate.update(sql, pEmail);
    }

    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM Customer";
        List<Customer> e = jdbcTemplate.query(sql,  new BeanPropertyRowMapper(Customer.class), new Object[]{});
        return e;
    }

}


