package com.example.demo.service;
import com.example.demo.model.*;
import com.example.demo.jsonResponse.Rooms;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminService(EmployeeRepository employeeRepository, CustomerRepository customerRepository, BookingRepository bookingRepository, RoomRepository roomRepository, RoomTypeRepository roomTypeRepository, JdbcTemplate jdbcTemplate) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Admin getAdmin(String emailID) {
        String sql = "SELECT * FROM admin WHERE emailID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Admin.class), new Object[]{emailID});
    }

    public void removeEmployee(String pEmail) {
        employeeRepository.removeEmployee(pEmail);
    }

    public void removeCustomer(String pEmail) {customerRepository.removeCustomer(pEmail);}

    public void addEmployee(Employee employee){
        employeeRepository.addEmployee(employee.getEmpID(), employee.getfName(), employee.getlName(), employee.getHouseNo(), employee.getPincode(), employee.getCity(), employee.getState(), employee.getCountry(), employee.getGender(), employee.getSalary(), employee.getAadhaarNo(), employee.getRole(), employee.getAccountNo(), employee.getIFSCCode(), employee.getBankName(), employee.getpEmail(), employee.getLoan(), employee.getLoanDetails());
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getAllEmployee();
    }

    public List<Customer> getCustomers() {
        return customerRepository.getAllCustomers();
    }

    public Employee getEmployeeByEmpID(UUID empID){
        return employeeRepository.getEmployeeById(empID);
    }

    public List<Booking> getBookings(){ return bookingRepository.getAllBookings(); }

    public List<RoomType>getAllRoomTypes() {return roomTypeRepository.getAllRoomTypes();}

    public List<Rooms>getAllRooms(){return roomRepository.getAllRooms();}

}