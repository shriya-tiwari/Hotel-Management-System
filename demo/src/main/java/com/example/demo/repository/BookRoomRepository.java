package com.example.demo.repository;
import com.example.demo.model.BookRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRoomRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addBookRoom(UUID roomID, UUID bookingID) {
        String sql = "INSERT INTO book_room (roomID, bookingID) VALUES (?,?)";
        try {
            return jdbcTemplate.update(sql, roomID.toString(), bookingID.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public BookRoom getBookRoomByBookingID(UUID bookingID) {
        String sql = "SELECT * FROM book_room WHERE bookingID = ?";
        BookRoom bk = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookRoom.class), new Object[]{bookingID.toString()});
        return bk;
    }

    public List<BookRoom> getBookRoomByRoomID(UUID roomID) {
        String sql = "SELECT * FROM book_room WHERE roomID = ?";
        List<BookRoom> bk = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookRoom.class), new Object[]{roomID.toString()});
        return bk;
    }

    public int deleteBookRoom(UUID bookingID){
        String sql = "DELETE FROM book_room where bookingID = ?";
        try {
            return jdbcTemplate.update(sql, bookingID.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
