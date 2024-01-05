package com.example.demo.repository;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addEmployee(UUID empID, String fName, String lName, String houseNo, String pincode, String city, String state, String country, String gender, int salary, String aadhaarNo, String role, String accountNo, String IFSCCode, String bankName, String pEmail, int loan, String loanDetails){
        String sql = "INSERT INTO employee (empID, fName, lName, houseNo, state, city, country, pincode, gender, aadhaarNo, pEmail, role, salary, loan, loanDetails, accountNo, IFSCCode, bankName) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            return jdbcTemplate.update(sql, empID.toString(), fName, lName, houseNo, state, city, country, pincode, gender, aadhaarNo, pEmail, role, salary, loan, loanDetails, accountNo, IFSCCode, bankName);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Employee getEmployeeById(UUID employeeID) {
        String sql = "SELECT * FROM employee WHERE employeeID = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), new Object[]{employeeID.toString()});
        return employee;
    }

    public int updateEmployeeAttribute(UUID employeeID, String attributeName, String attributeValue) {
        String sql = "UPDATE employee SET " + attributeName + " = ? WHERE employeeID = ?";
        return jdbcTemplate.update(sql, attributeValue, employeeID.toString());
    }

    public void deleteEmployee(UUID employeeID){
        String sql = "DELETE FROM employee where employeeID = ?";
        jdbcTemplate.update(sql, employeeID.toString());
    }

    public List<Employee> getAllEmployee() {
        String sql = "SELECT * FROM employee";
        List<Employee> e = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class), new Object[]{});
        for(int i=0; i<e.size(); i++) {
            Employee e1 = e.get(i);
            System.out.println(e1.getAadhaarNo());
            System.out.println(e1.getpEmail());
        }
        return e;
    }

    public void removeEmployee(String pEmail) {
        String sql = "DELETE FROM Employee WHERE pEmail = ?;";
        jdbcTemplate.update(sql, pEmail);
    }

}
