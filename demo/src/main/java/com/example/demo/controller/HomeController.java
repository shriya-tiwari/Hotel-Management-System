package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() { return "home"; }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "user_dashboard";
    }

    @GetMapping("/dashboard/profile")
    public String profile() { return "profile"; }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/experiences")
    public String experiences() {
        return "experiences";
    }

    @GetMapping("/dashboard/avail_service")
    public String avail_service() {
        return "avail_service";
    }

    @GetMapping("/dashboard/bookings")
    public String customerBookings() { return "bookings"; }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/rooms")
    public String rooms() { return "rooms"; }

    @GetMapping("/admin")
    public String admin() { return "admin_portal"; }

    @GetMapping("/adminLoginPage")
    public String adminLoginPage() { return "admin_login"; }

    @GetMapping("/admin/customers")
    public String adminCustomer() { return "customers"; }

    @GetMapping("/admin/deleteEmp")
    public String adminDeleteEmp() { return "delete_employee"; }

    @GetMapping("/admin/empForm")
    public String adminEmpForm() { return "employee_form"; }

    @GetMapping("/admin/empManagement")
    public String empManagement() { return "employee_management"; }

    @GetMapping("/admin/roomManagement")
    public String roomManagement() { return "room_management"; }

    @GetMapping("/admin/allBookings")
    public String allBookings() { return "all_bookings"; }

    @GetMapping("/admin/allEmployees")
    public String allEmployees() { return "all_emps"; }

    @GetMapping("/dashboard/bill")
    public String bill() { return "bill"; }


}
