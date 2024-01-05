package com.example.demo.controller;
import com.example.demo.jsonResponse.*;
import com.example.demo.model.*;
import com.example.demo.model.Customer;
import com.example.demo.service.BillService;
import com.example.demo.service.BookingService;
import com.example.demo.service.DashboardService;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:8080")
public class BookingController {

    private final BookingService bookingService;
    private final BillService billService;
    private final DashboardService dashboardService;
    private final ServiceService serviceService;

    @Autowired
    public BookingController(BookingService bookingService, BillService billService, DashboardService dashboardService, ServiceService serviceService) {
        this.bookingService = bookingService;
        this.billService = billService;
        this.dashboardService = dashboardService;
        this.serviceService = serviceService;
    }

    @PostMapping("/dashboard/check")
    public ResponseEntity checkAvail(@RequestBody BookingRequest bookingRequest) {
        System.out.println(bookingRequest.getRoomType());
        System.out.println(bookingRequest.getCheckInDate());
        System.out.println(bookingRequest.getNoOfGuests());
        if(bookingService.getAvail(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate(), bookingRequest.getRoomType())) {
            return ResponseEntity.ok("Rooms Available");
        }
        return ResponseEntity.badRequest().body("No rooms available");
    }

    @PostMapping("/dashboard/book")
    public Booking makeBooking(@RequestBody BookingRequest bookingRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String pEmail = userDetails.getUsername();
        Customer customer = dashboardService.getCustomerByEmail(pEmail);
        Room room = bookingService.getRoomForBooking(bookingRequest);
        UUID bookingID = UUID.randomUUID();
        Date checkInDate = bookingRequest.getCheckInDate();
        Date checkOutDate = bookingRequest.getCheckOutDate();
        int noOfGuests = bookingRequest.getNoOfGuests();
        System.out.println(noOfGuests);
        System.out.println(checkInDate);
        System.out.println(checkOutDate);
        System.out.println(room.getRoomID());
        bookingService.book(bookingID, checkInDate, checkOutDate, noOfGuests, customer.getCustomerID());
        bookingService.addBookRoom(bookingID, room.getRoomID());
        return bookingService.getBooking(bookingID);
    }

    @GetMapping("/getBookings")
    public List<GetBooking> getBookings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String pEmail = userDetails.getUsername();
        Customer customer = dashboardService.getCustomerByEmail(pEmail);
        List<GetBooking> res = bookingService.getGetBookings(customer.getCustomerID());
        System.out.println(res.get(0).getGetCheckInDate());
        return res;
    }

    @PostMapping("/deleteBooking")
    public ResponseEntity deleteBooking(@RequestBody Id id) {
        System.out.println("HI");
        try {
            bookingService.deleteBookRoom(id.getBookingID());
            bookingService.deleteBooking(id.getBookingID());
            serviceService.deleteServicesProvided(id.getBookingID());
            return ResponseEntity.ok("Booking cancelled");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Some error occurred");
        }
    }

    @PostMapping("/addService")
    public ResponseEntity addService(@RequestBody ServiceRequest sr) {
        Services s = serviceService.getServiceByName(sr.getServiceName());
        System.out.println(s.getName());
        try {
            serviceService.addServiceToBooking(s.getServiceID(), sr.getBookingID());
            return ResponseEntity.ok("Service added successfully.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Some error occurred.");
        }
    }

    @PostMapping("/getBill")
    public GenerateBill getBill(@RequestBody Id id) {
        GetBooking b = bookingService.getGetBooking(id.getBookingID());
        System.out.println(id.getBookingID());
        GenerateBill bill = new GenerateBill( b.getGetBookingID(), b.getGetCheckInDate(), b.getGetCheckOutDate(), b.getCost(), b.getTypeName(), b.getGetServices());
        return bill;
    }

}
