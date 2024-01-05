package com.example.demo.jsonResponse;
import java.util.UUID;

public class Customer {
    private UUID customerID;
    private String fName;
    private String lName;
    private String houseNo;
    private String state;
    private String city;
    private String country;
    private String pinCode;
    private String gender;
    private String aadhaarNo;
    private String password;
    private String pEmail;

    public Customer(UUID customerID, String fName, String lName, String houseNo, String state, String city, String country, String pinCode, String gender, String aadhaarNo, String password, String pEmail) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.houseNo = houseNo;
        this.state = state;
        this.city = city;
        this.country = country;
        this.pinCode = pinCode;
        this.gender = gender;
        this.aadhaarNo = aadhaarNo;
        this.password = password;
        this.pEmail = pEmail;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }
}
