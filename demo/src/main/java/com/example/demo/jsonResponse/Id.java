package com.example.demo.jsonResponse;

import java.util.UUID;

public class Id {
    private UUID bookingID;

    public Id(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public Id() { }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }
}
