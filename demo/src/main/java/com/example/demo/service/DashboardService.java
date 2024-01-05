package com.example.demo.service;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerEmail;
import com.example.demo.model.CustomerPhoneNo;
import com.example.demo.repository.CustomerEmailRepository;
import com.example.demo.repository.CustomerPhoneRepository;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class DashboardService {

    private final CustomerRepository customerRepository;
    private final CustomerPhoneRepository customerPhoneRepository;
    private final CustomerEmailRepository customerEmailRepository;

    @Autowired
    public DashboardService(CustomerRepository customerRepository, CustomerPhoneRepository customerPhoneRepository, CustomerEmailRepository customerEmailRepository) {
        this.customerRepository = customerRepository;
        this.customerPhoneRepository = customerPhoneRepository;
        this.customerEmailRepository = customerEmailRepository;
    }

    public Customer getCustomerByEmail(String pEmail) {
        return customerRepository.getCustomerByEmail(pEmail);
    }

    public Customer getCustomerByID(UUID customerID) {
        return customerRepository.getCustomerById(customerID);
    }

    public void updateCustomerAttribute(UUID customerID, String attributeName, String attributeValue) {
        customerRepository.updateCustomerAttribute(customerID, attributeName, attributeValue);
    }

    public int addAlterEmail(UUID customerID, String custEmailID) {
        return customerEmailRepository.addCustomerEmail(customerID, custEmailID);
    }

    public int addAlterPhoneNo(UUID customerID, String custPhoneNo) {
        return customerPhoneRepository.addCustomerPhone(customerID, custPhoneNo);
    }

    public void updateAlterEmail(UUID customerID, String custEmailID) {
        customerEmailRepository.updateCustomerEmail(customerID, custEmailID);
    }

    public void updateAlterPhone(UUID customerID, String custPhoneNo) {
        customerPhoneRepository.updateCustomerPhone(customerID, custPhoneNo);
    }

    public CustomerPhoneNo getCustomerPhoneByID(UUID customerID) {
        return customerPhoneRepository.getCustomerPhoneByID(customerID);
    }

    public CustomerEmail getCustomerEmailByID(UUID customerID) {
        return customerEmailRepository.getCustomerEmailByID(customerID);
    }

}
