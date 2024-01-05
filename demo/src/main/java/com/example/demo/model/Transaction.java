package com.example.demo.model;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private UUID transactionID;
    private String transactionType;
    private String verificationStatus;
    private String bankName;
    private String mode;
    private String branchName;
    private String accNo;
    private int amount;
    private Date tDate;
    private Time tTime;
    private int month;
    private int year;
    private UUID billID;
    private UUID bookingID;

    public Transaction() {
    }

    public Transaction(UUID transactionID, String transactionType, String verificationStatus, String bankName, String mode, String branchName, String accNo, int amount, Date tDate, Time tTime, int month, int year, UUID billID, UUID bookingID) {
        this.transactionID = transactionID;
        this.transactionType = transactionType;
        this.verificationStatus = verificationStatus;
        this.bankName = bankName;
        this.mode = mode;
        this.branchName = branchName;
        this.accNo = accNo;
        this.amount = amount;
        this.tDate = tDate;
        this.tTime = tTime;
        this.month = month;
        this.year = year;
        this.billID = billID;
        this.bookingID = bookingID;
    }

    public UUID getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(UUID transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public Time gettTime() {
        return tTime;
    }

    public void settTime(Time tTime) {
        this.tTime = tTime;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public UUID getBillID() {
        return billID;
    }

    public void setBillID(UUID billID) {
        this.billID = billID;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }
}
