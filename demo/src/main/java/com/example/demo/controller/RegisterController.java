package com.example.demo.controller;
import com.example.demo.jsonResponse.Customer;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@CrossOrigin(origins="http://localhost:8080")
public class RegisterController {
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;
    @Autowired

    public RegisterController(AuthenticationService authenticationService, PasswordEncoder passwordEncoder) {
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String submitRegister(@RequestBody Customer customer){
        UUID customerID=UUID.randomUUID();
        String fName=customer.getfName();
        String lName=customer.getlName();
        String pEmail=customer.getpEmail();
        System.out.println(customer.getPassword());
        String password=passwordEncoder.encode(customer.getPassword());
        String houseNo=customer.getHouseNo();
        String city=customer.getCity();
        String state=customer.getState();
        String country=customer.getCountry();
        String pinCode=customer.getPinCode();
        String gender=customer.getGender();
        String aadhaarNo=customer.getAadhaarNo();
        System.out.println(aadhaarNo);
        if(authenticationService.customerExist(pEmail)){
            System.out.println("Hello ");
            return "fail";
        }
        else{
            authenticationService.register(customerID, fName, lName, houseNo, state, city, country, pinCode, gender, aadhaarNo, password, pEmail);
            return fName+" "+lName+" "+houseNo+" "+state+" "+city+" "+country+" "+pinCode+" "+gender+" "+aadhaarNo+" "+password+" "+pEmail;
        }
    }
}
