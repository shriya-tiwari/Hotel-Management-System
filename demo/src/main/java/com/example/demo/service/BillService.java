package com.example.demo.service;
import com.example.demo.model.Bill;
import com.example.demo.repository.BillRepository;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Service
public class BillService {

    private final BillRepository billRepository;


    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBill(UUID bookingID){
        return billRepository.getBill(bookingID);
    }

    public void addBill(UUID billID, String transactionType, LocalDate tDate, int amount, UUID bookingID){
        billRepository.addBill(billID, transactionType, tDate, amount, bookingID);

    }
}
