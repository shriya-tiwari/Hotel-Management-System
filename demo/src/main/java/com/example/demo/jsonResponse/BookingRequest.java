package com.example.demo.jsonResponse;
import java.util.Date;

public class BookingRequest {

    private Date checkInDate;
    private Date checkOutDate;
    private String roomType;
    private int noOfGuests;

    public BookingRequest(Date checkInDate, Date checkOutDate, String roomType, int noOfGuests) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
        this.noOfGuests = noOfGuests;
    }

    public BookingRequest() {
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }
}
