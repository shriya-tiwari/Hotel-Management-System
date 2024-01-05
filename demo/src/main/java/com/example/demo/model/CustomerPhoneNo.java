package com.example.demo.model;

import java.util.UUID;

public class CustomerPhoneNo {

    private UUID customerID;
    private String custPhoneNo;

    public CustomerPhoneNo() {
    }

    public CustomerPhoneNo(UUID customerID, String custPhoneNo) {
        this.customerID = customerID;
        this.custPhoneNo = custPhoneNo;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public String getCustPhoneNo() {
        return custPhoneNo;
    }

    public void setCustPhoneNo(String custPhoneNo) {
        this.custPhoneNo = custPhoneNo;
    }
}
