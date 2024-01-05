package com.example.demo.jsonResponse;
import java.util.Date;
import java.util.UUID;

public class Bookings {
    private UUID bookingID;
    private Date checkInDate;
    private Date checkOutDate;
    private int noOfGuests;
    private String customerEmail;

    public Bookings() {
    }

    public Bookings(UUID bookingID, Date checkInDate, Date checkOutDate, int noOfGuests, String customerEmail) {
        this.bookingID = bookingID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfGuests = noOfGuests;
        this.customerEmail = customerEmail;
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

    public String getCustomerID() {
        return customerEmail;
    }

    public void setCustomerID(String customerID) {
        this.customerEmail = customerEmail;
    }
}
