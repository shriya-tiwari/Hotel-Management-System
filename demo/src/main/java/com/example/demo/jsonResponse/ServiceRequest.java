package com.example.demo.jsonResponse;
import java.util.UUID;

public class ServiceRequest {

    private String serviceName;
    public UUID bookingID;
    public String serviceDetails;

    public ServiceRequest(String serviceName, UUID bookingID, String serviceDetails) {
        this.serviceName = serviceName;
        this.bookingID = bookingID;
        this.serviceDetails = serviceDetails;
    }

    public ServiceRequest() { }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }
}
