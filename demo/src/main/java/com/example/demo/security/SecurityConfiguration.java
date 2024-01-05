package com.example.demo.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
    private final CustomerDetailsServiceImpl customerDetailsService;
    private final JwtFilter jwtFilter;

    public SecurityConfiguration(CustomerDetailsServiceImpl customerDetailsService, JwtFilter jwtFilter) {
        this.customerDetailsService = customerDetailsService;
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/", "/login",  "/addService", "/deleteBooking/**", "/deleteBooking", "/dashboard/avail_service", "/logout", "/dashboard/bookings", "/getProfile", "/dashboard", "/dashboard/book", "/dashboard/check", "/fetch-data", "/register", "/rooms", "/services", "/experiences", "/dashboard/profile", "/public/**").permitAll()
                        .requestMatchers("/admin", "/adminLoginPage", "/admin/addEmployee", "/admin/allBookings", "/admin-login",  "/admin/customers", "/admin/allCustomers", "/admin/deleteEmp", "/admin/empForm", "/dashboard/bill", "/admin/empManagement", "/admin/roomManagement", "/admin/allEmployees", "/admin/getAllEmployees", "/admin/getAllRooms", "/admin/deleteEmployee", "/admin/getRoomTypes", "/admin/getAllBookings", "/getBill").permitAll()

                                .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

}
