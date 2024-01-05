package com.example.demo.model;


import java.util.UUID;

public class RoomType {

    private UUID roomCodeID;
    private int totalRooms;
    private String typeName;
    private String typeDescription;

    public RoomType() {}

    public RoomType(UUID roomCodeID, int totalRooms, String typeName, String typeDescription) {
        this.roomCodeID = roomCodeID;
        this.totalRooms = totalRooms;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public UUID getRoomCodeID() {
        return roomCodeID;
    }

    public void setRoomCodeID(UUID roomCodeID) {
        this.roomCodeID = roomCodeID;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
}
