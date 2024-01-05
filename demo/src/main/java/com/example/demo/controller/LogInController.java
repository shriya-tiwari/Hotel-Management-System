package com.example.demo.controller;
import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AdminService;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class LogInController {
    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;
    private final AdminService adminService;

    private final JwtUtil jwtUtil;

    @Autowired

    public LogInController(AuthenticationManager authenticationManager, AuthenticationService authenticationService, JwtUtil jwtUtil, AdminService adminService) {
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
        this.jwtUtil = jwtUtil;
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity customerLogIn(@RequestBody Customer customer){
        String pEmail = customer.getpEmail();
        String password = customer.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(pEmail, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.createToken(authentication);
        Map<String,String> jsonResponse = new HashMap<>();
        jsonResponse.put("token",token);
        System.out.println(ResponseEntity.ok(jsonResponse));
        System.out.println("ddd");
        return ResponseEntity.ok(jsonResponse);
    }

    @PostMapping("/admin-login")
    public ResponseEntity adminLogin(@RequestBody Admin admin){
        String emailID = admin.getEmailID();
        String password = admin.getPassword();
        Admin a = adminService.getAdmin(emailID);
        if(password.equals(a.getPassword())) {
            Map<String, String> jsonResponse = new HashMap<>();
            jsonResponse.put("token", "admin");
            System.out.println(ResponseEntity.ok(jsonResponse));
            System.out.println("ddd");
            return ResponseEntity.ok(jsonResponse);
        }
        else {
            return ResponseEntity.badRequest().body("Incorrect credentials");
        }
    }
}
