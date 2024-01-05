package com.example.demo.controller;
import com.example.demo.jsonResponse.EditRequest;
import com.example.demo.jsonResponse.PasswordChangeRequest;
import com.example.demo.model.Customer;
import com.example.demo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DashboardController {

    private final DashboardService dashboardService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DashboardController(DashboardService dashboardService, PasswordEncoder passwordEncoder) {
        this.dashboardService = dashboardService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/getProfile")
    public Customer getProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();
        Customer customer = dashboardService.getCustomerByEmail(pEmail);
        System.out.println(customer);
        return customer;
    }

    @PutMapping("/editProfile")
    public String editProfile(@RequestBody EditRequest er) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();
        Customer customer = dashboardService.getCustomerByEmail(pEmail);
        dashboardService.updateCustomerAttribute(customer.getCustomerID(), er.getAttributeName(), er.getAttributeValue());
        return "Profile updated";
    }

    @PutMapping("/changePassword")
    public ResponseEntity changePassword(@RequestBody PasswordChangeRequest pcr) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String pEmail = userDetails.getUsername();
        Customer customer = dashboardService.getCustomerByEmail(pEmail);
        String nPassword = passwordEncoder.encode(pcr.getNewPassword());
        System.out.println(pcr.getNewPassword());
        System.out.println(nPassword);
        System.out.println(customer.getPassword());
        if(nPassword.equals(customer.getPassword())) {
            return ResponseEntity.badRequest().body("Current password is incorrect.");
        }
        dashboardService.updateCustomerAttribute(customer.getCustomerID(), "password", nPassword);
        return ResponseEntity.ok("Password changed successfully.");
    }
}
