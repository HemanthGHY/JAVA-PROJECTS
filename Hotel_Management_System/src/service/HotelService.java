package service;

import model.*;
import exception.*;
import java.time.LocalDate;
import java.util.*;

public class HotelService {
    private List<Room> rooms = new ArrayList<>();
    private Map<String, Guest> guests = new HashMap<>();
    private List<Booking> bookings = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();

    public HotelService() {
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Deluxe", 2500));
        rooms.add(new Room(103, "Suite", 4000));
    }

    public void addGuest(Guest guest) {
        guests.put(guest.getId(), guest);
    }

    public void bookRoom(String guestId, int roomNumber, LocalDate checkIn, LocalDate checkOut,double advance)
        throws RoomNotAvailableException, GuestNotFoundException {

        Room room = rooms.stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);
        if (room == null || room.isBooked()) {
            throw new RoomNotAvailableException("Room " + roomNumber + " is not available.");
        }

        Guest guest = guests.get(guestId);
        if (guest == null) throw new GuestNotFoundException("Guest ID not found.");

        room.book();
        Booking booking = new Booking(guest, room, checkIn, checkOut);
        bookings.add(booking);
        double totalAmount = new BillingService().calculateBill(bookings.getLast());
        double advanceAmount = advance;
        // Payment pay = new Payment(room.getRoomNumber(),totalAmount,advanceAmount);
        Payment pay = new Payment(String.valueOf(room.getRoomNumber()), totalAmount, advanceAmount);
        payments.add(pay);
    }

    public boolean checkout(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && r.isBooked()) {
                for(Payment p:payments){
                    if(p.getpaymentId().equals(String.valueOf(r.getRoomNumber()))){
                        p.setStatusPaid();
                        }
                }
                r.vacate();
                return true;
            }
        }
        return false;
    }
    public void showGuests(){
        if(guests.isEmpty()){
            System.out.println("No guests in the hotel");
            return;
        }
        System.out.printf("%10s %20s %15s\n","ID","NAME","CONTACT");
        guests.entrySet().stream()
              .forEach(entry -> System.out.printf("%10s %20s %15s\n",entry.getKey(),entry.getValue().getName(),entry.getValue().getContact()));
    }
    public void showGuests2(){
        if(guests.isEmpty()){
            System.out.println("No guests in the hotel");
            return;
        }
        guests.entrySet().stream()
              .forEach(entry -> System.out.println(entry.getValue()));
    }
    public void billings(){
        if(payments.isEmpty()){
            System.out.println("No payments in the hotel");
            return;
        }
        // payments.stream().forEach(p-> System.out.println());
        payments.forEach(System.out::println);
    }
    public void showRooms() {
        rooms.forEach(System.out::println);
    }

    public void showBookings() {
        if(bookings.isEmpty()){
            System.out.println("No bookings in the hotel");
            return;
        }
        bookings.forEach(System.out::println);
    }
}