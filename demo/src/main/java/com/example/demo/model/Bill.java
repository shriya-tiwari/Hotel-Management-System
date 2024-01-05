package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

public class Bill {
    private UUID billID;
    private String transactionType;
    private Date tDate;
    private int amount;
    private UUID bookingID;

    public Bill() {
    }

    public Bill(UUID billID, String transactionType, Date tDate, int amount, UUID bookingID) {
        this.billID = billID;
        this.transactionType = transactionType;
        this.tDate = tDate;
        this.amount = amount;
        this.bookingID = bookingID;
    }

    public UUID getBillID() {
        return billID;
    }

    public void setBillID(UUID billID) {
        this.billID = billID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }
}
