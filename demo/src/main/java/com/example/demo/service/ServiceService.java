package com.example.demo.service;
import com.example.demo.model.Services;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.ServicesProvidedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final ServicesProvidedRepository servicesProvidedRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository, ServicesProvidedRepository servicesProvidedRepository, JdbcTemplate jdbcTemplate) {
        this.servicesProvidedRepository = servicesProvidedRepository;
        this.serviceRepository = serviceRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addService(UUID serviceID, String name, int cost, String description) {
        return serviceRepository.addService(serviceID, name, cost, description);
    }

    public int addServiceToBooking(UUID serviceID, UUID bookingID) {
        return servicesProvidedRepository.addServiceToBooking(bookingID, serviceID);
    }

    public int deleteServicesProvided(UUID bookingID) {
        return servicesProvidedRepository.deleteServicesProvided(bookingID);
    }

    public Services getServiceByName(String serviceName) {
        return serviceRepository.getServiceByName(serviceName);
    }
}


