package com.example.demo.jsonResponse;


public class JEmployee {

    private String fName;
    private String lName;
    private String houseNo;
    private String pincode;
    private String city;
    private String state;
    private String country;
    private String gender;
    private int salary;
    private String aadhaarNo;
    private String role;
    private String accountNo;
    private String IFSCCode;
    private String bankName;
    private String pEmail;
    private int loan;
    private String loanDetails;

    public JEmployee(String fName, String lName, String houseNo, String pincode, String city, String state, String country, String gender, int salary, String aadhaarNo, String role, String accountNo, String IFSCCode, String bankName, String pEmail, int loan, String loanDetails) {
        this.fName = fName;
        this.lName = lName;
        this.houseNo = houseNo;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.gender = gender;
        this.salary = salary;
        this.aadhaarNo = aadhaarNo;
        this.role = role;
        this.accountNo = accountNo;
        this.IFSCCode = IFSCCode;
        this.bankName = bankName;
        this.pEmail = pEmail;
        this.loan = loan;
        this.loanDetails = loanDetails;
    }

    public JEmployee() {
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public String getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(String loanDetails) {
        this.loanDetails = loanDetails;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
