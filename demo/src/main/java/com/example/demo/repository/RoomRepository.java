package com.example.demo.repository;
import com.example.demo.jsonResponse.Rooms;
import com.example.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class RoomRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addRoom(UUID roomID, UUID roomCodeID, int cost, int occupancyLimit, String roomNo) {
        String sql = "INSERT INTO room (roomID, roomCodeID, cost, occupancyLimit, roomNo) VALUES (?,?,?,?,?)";
        try {
            return jdbcTemplate.update(sql, roomID.toString(), roomCodeID.toString(), cost, occupancyLimit, roomNo);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public void deleteRoom(UUID roomID){
        String sql = "DELETE FROM room where roomID = ?";
        jdbcTemplate.update(sql, roomID.toString());
    }

    public Room getRoomByID(UUID roomID) {
        System.out.println(roomID);
        String sql = "SELECT * FROM room WHERE roomID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Room.class), new Object[]{roomID.toString()});
    }

    public List<Rooms> getAllRooms() {
        String sql = "SELECT r.roomID, rt.typeName AS roomType, r.cost, r.occupancyLimit FROM Room r, Room_Type rt WHERE r.roomCodeID = rt.roomCodeID;";
        try{
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Rooms.class), new Object[]{});
        }
        catch ( Exception e){
            System.out.println(e);
            return new ArrayList<Rooms>();
        }
    }

}
