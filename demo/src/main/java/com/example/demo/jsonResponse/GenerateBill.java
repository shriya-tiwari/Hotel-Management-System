package com.example.demo.jsonResponse;
import com.example.demo.model.Services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class GenerateBill {

    private UUID bookingID;
    private Date checkInDate;
    private Date checkOutDate;
    private int cost;
    private String typeName;
    private List<String> services;


    public GenerateBill( UUID bookingID, Date checkInDate, Date checkOutDate, int cost, String typeName, List<String> services) {

        this.bookingID = bookingID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.cost = cost;
        this.typeName = typeName;
        this.services = services;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
