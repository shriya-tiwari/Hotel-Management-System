package com.example.demo.model;


import java.util.UUID;

public class ServicesProvided {
    private UUID serviceID;
    private UUID bookingID;

    public ServicesProvided() {
    }

    public ServicesProvided(UUID serviceID, UUID bookingID) {
        this.serviceID = serviceID;
        this.bookingID = bookingID;
    }

    public UUID getServiceID() {
        return serviceID;
    }

    public void setServiceID(UUID serviceID) {
        this.serviceID = serviceID;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }
}
