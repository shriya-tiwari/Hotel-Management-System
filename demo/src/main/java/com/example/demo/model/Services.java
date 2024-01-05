package com.example.demo.model;


import java.util.UUID;

public class Services {
    private UUID serviceID;
    private String name;
    private int cost;
    private String description;

    public Services() {
    }

    public Services(UUID serviceID, String name, int cost, String description) {
        this.serviceID = serviceID;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public UUID getServiceID() {
        return serviceID;
    }

    public void setServiceID(UUID serviceID) {
        this.serviceID = serviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
