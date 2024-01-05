package com.example.demo.security;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class CustomerDetailsServiceImpl implements UserDetailsService{
    private final CustomerRepository customerRepository;

    public CustomerDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String pEmail) throws UsernameNotFoundException {
        try {
            Customer customer = customerRepository.getCustomerByEmail(pEmail);
            if(customer != null){
                return new org.springframework.security.core.userdetails.User(customer.getpEmail(), customer.getPassword(), new ArrayList<>());
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
