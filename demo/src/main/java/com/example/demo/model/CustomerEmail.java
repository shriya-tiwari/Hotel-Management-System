package com.example.demo.model;

import java.util.UUID;

public class CustomerEmail {

    private UUID customerID;
    private String custEmailId;

    public CustomerEmail() {
    }

    public CustomerEmail(UUID customerID, String custEmailId) {
        this.customerID = customerID;
        this.custEmailId = custEmailId;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public String getCustEmailId() {
        return custEmailId;
    }

    public void setCustEmailId(String custEmailId) {
        this.custEmailId = custEmailId;
    }
}
