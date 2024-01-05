package com.example.demo.model;

import java.util.UUID;

public class Room {

    private UUID roomID;
    private UUID roomCodeID;
    private int cost;
    private int occupancyLimit;
    private String roomNo;

    public Room() {
    }

    public Room(UUID roomID, UUID roomCodeID, int cost, int occupancyLimit, String roomNo) {
        this.roomID = roomID;
        this.roomCodeID = roomCodeID;
        this.cost = cost;
        this.occupancyLimit = occupancyLimit;
        this.roomNo = roomNo;
    }

    public UUID getRoomID() {
        return roomID;
    }

    public void setRoomID(UUID roomID) {
        this.roomID = roomID;
    }

    public UUID getRoomCodeID() {
        return roomCodeID;
    }

    public void setRoomCodeID(UUID roomCodeID) {
        this.roomCodeID = roomCodeID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOccupancyLimit() {
        return occupancyLimit;
    }

    public void setOccupancyLimit(int occupancyLimit) {
        this.occupancyLimit = occupancyLimit;
    }

    public String getRoomNo() { return roomNo; }

    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }
}
