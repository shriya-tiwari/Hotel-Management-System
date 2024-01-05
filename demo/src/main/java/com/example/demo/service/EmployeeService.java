package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(UUID empID, String fName, String lName, String houseNo, String pincode, String city, String state, String country, String gender, int salary, String aadharNo, String role, String accountNo, String IFSCCode, String bankName, String pEmail, int loan, String loanDetails){
        employeeRepository.addEmployee(empID, fName, lName, houseNo, pincode, city, state, country, gender, salary, aadharNo, role, accountNo, IFSCCode, bankName, pEmail, loan, loanDetails);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getAllEmployee();
    }

    public void deleteEmployee(UUID employeeID) {
        employeeRepository.deleteEmployee(employeeID);
    }

    public int updateEmployeeAttribute(UUID employeeID, String attributeName, String attributeValue) {
        return employeeRepository.updateEmployeeAttribute(employeeID, attributeName, attributeValue);
    }

    public Employee getEmployeeByID(UUID employeeID) {
        Employee employee = employeeRepository.getEmployeeById(employeeID);
        return employee;
    }
}
