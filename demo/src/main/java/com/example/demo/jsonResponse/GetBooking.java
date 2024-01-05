package com.example.demo.jsonResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class GetBooking {

    private UUID bookingID;
    private Date checkInDate;
    private Date checkOutDate;
    private String typeName;
    private String roomNo;
    private int noOfGuests;
    private int cost;
    private List<String> services;

    public GetBooking() {
    }

    public GetBooking(UUID bookingID, Date checkInDate, Date checkOutDate, int noOfGuests, List<String> services, int cost, String roomNo, String typeName) {
        this.bookingID = bookingID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfGuests = noOfGuests;
        this.services = services;
        this.cost = cost;
        this.roomNo = roomNo;
        this.typeName = typeName;
    }

    public UUID getGetBookingID() {
        return bookingID;
    }

    public void setGetBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public Date getGetCheckInDate() {
        return checkInDate;
    }

    public void setGetCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getGetCheckOutDate() {
        return checkOutDate;
    }

    public void setGetCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getGetNoOfGuests() {
        return noOfGuests;
    }

    public void setGetNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public List<String> getGetServices() {
        return services;
    }

    public void setGetServices(List<String> services) {
        this.services = services;
    }

    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }

    public String getRoomNo() { return roomNo; }

    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public String getTypeName() { return typeName; }

    public void setTypeName(String typeName) { this.typeName = typeName; }
}

