package com.example.demo.model;

import java.util.UUID;

public class EmpServices {
    private UUID employeeID;
    private UUID serviceID;

    public EmpServices() {
    }

    public EmpServices(UUID employeeID, UUID serviceID) {
        this.employeeID = employeeID;
        this.serviceID = serviceID;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public UUID getServiceID() {
        return serviceID;
    }

    public void setServiceID(UUID serviceID) {
        this.serviceID = serviceID;
    }
}
