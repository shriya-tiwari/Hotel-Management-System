package com.example.demo.service;
import com.example.demo.jsonResponse.BookingRequest;
import com.example.demo.jsonResponse.Bookings;
import com.example.demo.jsonResponse.GenerateBill;
import com.example.demo.jsonResponse.GetBooking;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ServicesProvidedRepository servicesProvidedRepository;
    private final ServiceRepository serviceRepository;
    private final BookRoomRepository bookRoomRepository;
    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, ServicesProvidedRepository servicesProvidedRepository, ServiceRepository serviceRepository, BookRoomRepository bookRoomRepository, RoomRepository roomRepository, RoomTypeRepository roomTypeRepository) {
        this.bookingRepository = bookingRepository;
        this.servicesProvidedRepository = servicesProvidedRepository;
        this.serviceRepository = serviceRepository;
        this.bookRoomRepository = bookRoomRepository;
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
    }

    public int book(UUID bookingID, Date checkInDate, Date checkOutDate, int noOfGuests, UUID customerID) {
        return bookingRepository.book(bookingID, checkInDate, checkOutDate, noOfGuests, customerID);
    }

    public int addBookRoom(UUID bookingID, UUID roomID) {
        return bookRoomRepository.addBookRoom(roomID, bookingID);
    }

    public Room getRoomForBooking(BookingRequest bookingRequest) {
        String roomType = bookingRequest.getRoomType();
        if(roomType.equals("deluxe")) {
            List<Room> r = bookingRepository.getRoomDeluxe(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());
            return r.get(0);
        }
        else if(roomType.equals("super_deluxe")) {
            List<Room> r = bookingRepository.getRoomSuperDeluxe(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());
            return r.get(0);
        }
        else if(roomType.equals("imperial")) {
            List<Room> r = bookingRepository.getRoomImperial(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());
            return r.get(0);
        }
        else if(roomType.equals("cottage")){
            List<Room> r = bookingRepository.getRoomCottage(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());
            return  r.get(0);
        }
        else {
            List<Room> r = bookingRepository.getRoomClubroomsWithJharokha(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());
            return r.get(0);
        }
    }

    public boolean getAvail(Date checkInDate, Date checkOutDate, String typeName) {
        if(typeName.equals("deluxe")) {
            return bookingRepository.getDeluxe(checkInDate, checkOutDate) > 0;
        }
        else if(typeName.equals("super_deluxe")) {
            return bookingRepository.getSuperDeluxe(checkInDate, checkOutDate) > 0;
        }
        else if(typeName.equals("imperial")) {
            return bookingRepository.getImperial(checkInDate, checkOutDate) > 0;
        }
        else if(typeName.equals("cottage")) {
            return bookingRepository.getCottage(checkInDate, checkOutDate) > 0;
        }
        else {
            return bookingRepository.getClubroomsWithJharokha(checkInDate, checkOutDate) > 0;
        }
    }

    public List<GetBooking> getGetBookings(UUID customerID) {
        List<GetBooking> gb = bookingRepository.getGetBooking(customerID);
        for(int i=0; i<gb.size(); i++) {
            List<ServicesProvided> sp = servicesProvidedRepository.getServicesByBookingID(gb.get(i).getGetBookingID());
            List<String> services = new ArrayList<String>();

            Date startDate = gb.get(i).getGetCheckInDate();
            Date endDate = gb.get(i).getGetCheckOutDate();

            long timeDifferenceInMillis = endDate.getTime() - startDate.getTime();
            long daysDifference = timeDifferenceInMillis / (1000 * 60 * 60 * 24);
            int daysDifferenceAsInt = (int) daysDifference;

            int price = gb.get(i).getCost()*daysDifferenceAsInt;
            for(int j=0; j<sp.size(); j++) {
                Services s = serviceRepository.getServiceByID(sp.get(j).getServiceID());
                String serviceName = s.getName();
                price += s.getCost();
                services.add(serviceName);
            }
            gb.get(i).setGetServices(services);
            gb.get(i).setCost(price);
        }
        return gb;
    }

    public GetBooking getGetBooking(UUID bookingID) {
        List<ServicesProvided> sp = servicesProvidedRepository.getServicesByBookingID(bookingID);
        List<String> services = new ArrayList<String>();
        Booking b = getBooking(bookingID);
        BookRoom bk = bookRoomRepository.getBookRoomByBookingID(b.getBookingID());
        Room room = roomRepository.getRoomByID(bk.getRoomID());
        RoomType rt = roomTypeRepository.getRoomTypeByID(room.getRoomCodeID());
        int cost = room.getCost();
        String roomNo = room.getRoomNo();
        Date startDate = b.getCheckInDate();
        Date endDate = b.getCheckOutDate();

        long timeDifferenceInMillis = endDate.getTime() - startDate.getTime();
        long daysDifference = timeDifferenceInMillis / (1000 * 60 * 60 * 24);
        int daysDifferenceAsInt = (int) daysDifference;

        int price = cost*daysDifferenceAsInt;
        for(int j=0; j<sp.size(); j++) {
            Services s = serviceRepository.getServiceByID(sp.get(j).getServiceID());
            String serviceName = s.getName();
            price += s.getCost();
            services.add(serviceName);
        }
        GetBooking gb = new GetBooking(bookingID, b.getCheckInDate(), b.getCheckOutDate(), b.getNoOfGuests(), services, price, roomNo, rt.getTypeName());
        return gb;
    }

    public Booking getBooking(UUID bookingID) {
        return bookingRepository.getBooking(bookingID);
    }

    public int deleteBookRoom(UUID bookingID) {
        return bookRoomRepository.deleteBookRoom(bookingID);
    }

    public int deleteBooking(UUID bookingID) {
        return bookingRepository.deleteBooking(bookingID);
    }
}
