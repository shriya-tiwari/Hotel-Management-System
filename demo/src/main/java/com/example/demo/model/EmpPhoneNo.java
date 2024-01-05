package com.example.demo.model;

import java.util.UUID;

public class EmpPhoneNo {
    private String empPhoneNo;
    private UUID employeeID;

    public EmpPhoneNo() {
    }

    public EmpPhoneNo(String empPhoneNo, UUID employeeID) {
        this.empPhoneNo = empPhoneNo;
        this.employeeID = employeeID;
    }

    public String getEmpPhoneNo() {
        return empPhoneNo;
    }

    public void setEmpPhoneNo(String empPhoneNo) {
        this.empPhoneNo = empPhoneNo;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }
}
