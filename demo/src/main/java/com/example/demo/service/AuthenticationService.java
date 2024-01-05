package com.example.demo.service;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AuthenticationService {
    private final CustomerRepository customerRepository;
    private String SESSION_KEY = "USER_SESSION";

    @Autowired
    public AuthenticationService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void register(UUID customerID, String fName, String lName, String houseNo, String state, String city, String country, String pinCode, String gender, String aadhaarNo, String password, String pEmail) {
        try {
            System.out.println(customerID.toString());
            customerRepository.registerCustomer(customerID, fName, lName, houseNo, state, city, country, pinCode, gender, aadhaarNo, password, pEmail);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Boolean checkCustomerCredentials(String pEmail, String password) {
        Customer customer = customerRepository.getCustomerByEmail(pEmail);
        return customer.getPassword().equals(password);
    }


    public boolean customerExist(String pEmail) {
        return customerRepository.customerExist(pEmail);
    }

}
