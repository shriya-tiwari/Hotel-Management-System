package com.example.demo.repository;
import com.example.demo.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class RoomTypeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomTypeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addRoomType(UUID roomCodeID, String typeName, String typeDescription) {
        String sql = "INSERT INTO room_type (roomCodeID, totalRooms, typeName, typeDescription) VALUES (?,?,?,?)";
        try {
            return jdbcTemplate.update(sql, roomCodeID.toString(), typeName, typeDescription);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public RoomType getRoomTypeByID(UUID roomCodeID) {
        String sql = "SELECT * FROM room_type WHERE roomCodeID = ?";
        RoomType roomType = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(RoomType.class), new Object[]{roomCodeID.toString()});
        return roomType;
    }

    public List<RoomType> getAllRoomTypes() {
        String sql = "SELECT * FROM room_type";
        try{
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RoomType.class), new Object[]{});
        }
        catch ( Exception e){
            System.out.println(e);
            return new ArrayList<RoomType>();
        }
    }
}
