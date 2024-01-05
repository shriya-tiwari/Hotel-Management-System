package com.example.demo.controller;
import com.example.demo.jsonResponse.Bookings;
import com.example.demo.jsonResponse.Email;
import com.example.demo.jsonResponse.JEmployee;
import com.example.demo.jsonResponse.Rooms;
import com.example.demo.model.Booking;
import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AdminController {

    private final AdminService adminService;
    private final ServiceService serviceService;
    private final AuthenticationService authenticationService;
    private final DashboardService dashboardService;

    @Autowired
    public AdminController(AdminService adminService, ServiceService serviceService, AuthenticationService authenticationService, DashboardService dashboardService) {
        this.adminService = adminService;
        this.serviceService = serviceService;
        this.authenticationService = authenticationService;
        this.dashboardService = dashboardService;
    }

    @GetMapping("/admin/getAllEmployees")
    public List<Employee> getAllEmployees(){
        List<Employee> u = adminService.getEmployees();
        System.out.println(u.get(0).getSalary());

        return u;
    }

    @PostMapping("/admin/deleteEmployee")
    public String deleteEmployee(@RequestBody Email pEmail){
        String email = pEmail.getpEmail();
        adminService.removeEmployee(email);
        return "deleted user with Email" + email;
    }

    @PostMapping("/admin/addEmployee")
    public String addEmployee(@RequestBody JEmployee userEmployee){
        System.out.println(userEmployee.getPincode());

        UUID empID = UUID.randomUUID();
        Employee employee = new Employee(
                empID,
                userEmployee.getfName(),
                userEmployee.getlName(),
                userEmployee.getHouseNo(),
                userEmployee.getPincode(),
                userEmployee.getCity(),
                userEmployee.getState(),
                userEmployee.getCountry(),
                userEmployee.getGender(),
                userEmployee.getSalary(),
                userEmployee.getAadhaarNo(),
                userEmployee.getRole(),
                userEmployee.getAccountNo(),
                userEmployee.getIFSCCode(),
                userEmployee.getBankName(),
                userEmployee.getpEmail(),
                userEmployee.getLoan(),
                userEmployee.getLoanDetails()
        );
        adminService.addEmployee(employee);

        return "Added Employee";
    }

    @PostMapping("/admin/getEmpByEmpID")
    public String getEmpByEmpID(@RequestBody Employee employee){
        Employee e = adminService.getEmployeeByEmpID(employee.getEmpID());
        return e.getpEmail();
    }

    @PostMapping("/admin/deleteCustomer")
    public String deleteCustomer(@RequestBody Customer user){
        String pEmail = user.getpEmail();
        adminService.removeCustomer(pEmail);
        return "deleted user with pEmail" + pEmail;
    }

    @GetMapping("/admin/allCustomers")
    public List<Customer> allCustomers(){
        List<Customer> u = adminService.getCustomers();
        return u;
    }

    @GetMapping("/admin/getAllBookings")
    public List<Bookings> getAllBookings(){
        List<Booking> b = adminService.getBookings();
        List<Bookings> res = new ArrayList<>();
        for(int i=0; i<b.size(); i++) {
            Customer c = dashboardService.getCustomerByID(b.get(i).getCustomerID());
            Bookings r = new Bookings(b.get(i).getBookingID(), b.get(i).getCheckInDate(), b.get(i).getCheckOutDate(), b.get(i).getNoOfGuests(), c.getpEmail());
            res.add(r);
        }
        return res;
    }

    @GetMapping("/admin/getRoomTypes")
    public List<RoomType>allRoomTypes(){
        List<RoomType> r = adminService.getAllRoomTypes();
        return r;
    }

    @GetMapping("/admin/getAllRooms")
    public List<Rooms>allRooms(){
        List<Rooms> r = adminService.getAllRooms();
        return r;
    }
}