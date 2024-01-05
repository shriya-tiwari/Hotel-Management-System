package com.example.demo.model;

import java.util.UUID;

public class EmpEmail {
    private UUID employeeID;
    private String empEmailId;

    public EmpEmail() {
    }

    public EmpEmail(UUID employeeID, String empEmailId) {
        this.employeeID = employeeID;
        this.empEmailId = empEmailId;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmpEmailId() {
        return empEmailId;
    }

    public void setEmpEmailId(String empEmailId) {
        this.empEmailId = empEmailId;
    }
}
