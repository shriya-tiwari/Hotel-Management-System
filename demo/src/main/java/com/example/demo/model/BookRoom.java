package com.example.demo.model;

import java.util.UUID;

public class BookRoom {
    private UUID roomID;
    private UUID bookingID;

    public BookRoom() {
    }

    public BookRoom(UUID roomID, UUID bookingID) {
        this.roomID = roomID;
        this.bookingID = bookingID;
    }

    public UUID getRoomID() {
        return roomID;
    }

    public void setRoomID(UUID roomID) {
        this.roomID = roomID;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }
}
