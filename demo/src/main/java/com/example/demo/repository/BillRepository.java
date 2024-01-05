package com.example.demo.repository;
import com.example.demo.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Repository
public class BillRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BillRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBill(UUID billID, String transactionType, LocalDate tDate, int amount, UUID bookingID){
        String sql = "INSERT INTO Bill(billID, transactionType, tDate, amount, bookingID) values (?,?,?,?,?)";

        jdbcTemplate.update(sql, billID.toString(), transactionType, tDate, amount, bookingID.toString());
    }

    public Bill getBill(UUID bookingID){
        String sql = "SELECT * FROM Bill where bookingID=?";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{bookingID.toString()}, new BeanPropertyRowMapper<>(Bill.class));
        }
        catch(Exception e){
            System.out.println(e);
            return new Bill();
        }
    }
}
