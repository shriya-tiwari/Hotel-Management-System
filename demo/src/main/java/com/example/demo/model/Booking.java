package com.example.demo.model;
import java.util.Date;
import java.util.UUID;

public class Booking {

    private UUID bookingID;
    private Date checkInDate;
    private Date checkOutDate;
    private int noOfGuests;
    private UUID customerID;

    public Booking() {
    }

    public Booking(UUID bookingID, Date checkInDate, Date checkOutDate, int noOfGuests, UUID customerID) {
        this.bookingID = bookingID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfGuests = noOfGuests;
        this.customerID = customerID;
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

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }
}
