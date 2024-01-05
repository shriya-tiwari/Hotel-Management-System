package com.example.demo.repository;
import com.example.demo.jsonResponse.GetBooking;
import com.example.demo.model.BookRoom;
import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class BookingRepository {

    private final JdbcTemplate jdbcTemplate;
    private final BookRoomRepository bookRoomRepository;
    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate, BookRoomRepository bookRoomRepository, RoomRepository roomRepository, RoomTypeRepository roomTypeRepository){
        this.bookRoomRepository = bookRoomRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
    }

    public int getDeluxe(Date in, Date out){
        String sql = "select count(*) from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Deluxe') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 3;
    }

    public int getSuperDeluxe(Date in, Date out){
        String sql = "select count(*) from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Super Deluxe') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 3;
    }

    public int getCottage(Date in, Date out){
        String sql = "select count(*) from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Cottage') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 3;
    }

    public int getImperial(Date in, Date out){
        String sql = "select count(*) from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Imperial') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 3;
    }

    public int getClubroomsWithJharokha(Date in, Date out){
        String sql = "select count(*) from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Club rooms with jharokha') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 3;
    }

    public List<Room> getRoomDeluxe(Date in, Date out){
        String sql = "select * from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Deluxe') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Room.class), new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
            return new ArrayList<Room>();
        }
    }

    public List<Room> getRoomSuperDeluxe(Date in, Date out){
        String sql = "select * from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Super Deluxe') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Room.class), new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
            return new ArrayList<Room>();
        }
    }

    public List<Room> getRoomCottage(Date in, Date out){
        String sql = "select * from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Cottage') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Room.class), new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
            return new ArrayList<Room>();
        }
    }

    public List<Room> getRoomImperial(Date in, Date out){
        String sql = "select * from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Imperial') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Room.class), new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
            return new ArrayList<Room>();
        }
    }

    public List<Room> getRoomClubroomsWithJharokha(Date in, Date out){
        String sql = "select * from Room where roomCodeID IN " +
                "(select roomCodeID from Room_Type where typeName='Club rooms with jharokha') and roomID NOT IN" +
                "(select roomID from Book_Room where bookingID IN" +
                "(select Booking.bookingID from Booking where checkOutDate>? and checkInDate<?))";
        try{
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Room.class), new Object[]{in, out});
        }
        catch (Exception e){
            System.out.println(e);
            return new ArrayList<Room>();
        }
    }

    public int book(UUID bookingID, Date checkInDate, Date checkOutDate, int noOfGuests, UUID customerID) {
        String sql = "INSERT INTO Booking(bookingID, checkInDate, checkOutDate, noOfGuests, customerID) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, bookingID.toString(), checkInDate, checkOutDate, noOfGuests, customerID.toString());
    }

    public List<Booking> getBookings(UUID customerID){
        String sql = "Select * from Booking where customerID = ?";
        List<Booking> bookings= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Booking.class), new Object[]{customerID.toString()});
        return bookings;
    }

    public int numDeluxe(UUID bookingID){
        String sql = "Select count(*) from Room where roomID in (Select roomID from book_room where bookingID=?) and roomCodeID IN" +
                "(select roomCodeID from Room_Type where typeName='Deluxe')";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{bookingID.toString()});

    }

    public int numSuperDeluxe(UUID bookingID){
        String sql = "Select count(*) from Room where roomID in (Select roomID from Book_Room where bookingID=?) and roomCodeID IN" +
                "(select roomCodeID from Room_Type where typeName='Super Deluxe')";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{bookingID.toString()});

    }

    public int numCottage(UUID bookingID){
        String sql = "Select count(*) from Room where roomID in (Select roomID from Book_Room where bookingID=?) and roomCodeID IN" +
                "(select roomCodeID from Room_Type where typeName='Cottage')";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{bookingID.toString()});

    }

    public int numImperial(UUID bookingID){
        String sql = "Select count(*) from Room where roomID in (Select roomID from Book_Room where bookingID=?) and roomCodeID IN" +
                "(select roomCodeID from Room_Type where typeName='Imperial')";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{bookingID.toString()});

    }

    public int numClubroomsWithJharokha(UUID bookingID){
        String sql = "Select count(*) from Room where roomID in (Select roomID from Book_Room where bookingID=?) and roomCodeID IN" +
                "(select roomCodeID from Room_Type where typeName='Club rooms with jharokha')";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{bookingID.toString()});

    }

    public List<GetBooking> getGetBooking(UUID customerID){
        List<Booking> bookings = getBookings(customerID);
        System.out.println(customerID);
        List<GetBooking> gb = new ArrayList<>();
        for(int i=0; i<bookings.size(); i++){
            System.out.println("d");
            System.out.println(bookings.get(i).getCheckInDate());
            System.out.println(bookings.get(i).getBookingID());
            System.out.println(bookings.get(i).getCheckOutDate());
            BookRoom bk = bookRoomRepository.getBookRoomByBookingID(bookings.get(i).getBookingID());
            Room room = roomRepository.getRoomByID(bk.getRoomID());
            System.out.println(room.getRoomID());
            RoomType rt = roomTypeRepository.getRoomTypeByID(room.getRoomCodeID());
            int cost = room.getCost();
            String roomNo = room.getRoomNo();
            GetBooking getBook = new GetBooking(bookings.get(i).getBookingID(), bookings.get(i).getCheckInDate(), bookings.get(i).getCheckOutDate(), bookings.get(i).getNoOfGuests(), new ArrayList<>(), cost, roomNo, rt.getTypeName());
            gb.add(getBook);
        }
        return gb;
    }

    public Booking getBooking(UUID bookingID) {
        String sql = "SELECT * FROM booking WHERE bookingID = ?";
        Booking b = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Booking.class), new Object[]{bookingID.toString()});
        return b;
    }

    public int deleteBooking(UUID bookingID){
        String sql = "DELETE FROM booking where bookingID = ?";
        try {
            return jdbcTemplate.update(sql, bookingID.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Booking> getAllBookings() {
        String sql = "SELECT * FROM Booking";
        List<Booking> e = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(Booking.class));
        return e;
    }

}
