import model.*;
import service.*;
import exception.*;
import utils.InputHelper;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        HotelService hotel = new HotelService();

        while (true) {
            System.out.println("\n--- Hotel Management Menu ---");
            System.out.println("1. Show Rooms");
            System.out.println("2. Add Guest");
            System.out.println("3. Book Room");
            System.out.println("4. Checkout Room");
            System.out.println("5. Show Guests");
            System.out.println("6. View Bookings");
            System.out.println("7. Billings");
            System.out.println("0. Exit");

            int choice = InputHelper.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    hotel.showRooms();
                    break;
                case 2:
                    String name = InputHelper.readString("Name: ");
                    String contact = InputHelper.readString("Contact: ");
                    String id = InputHelper.readString("ID: ");
                    hotel.addGuest(new Guest(name, contact, id));
                    break;
                case 3:
                    try {
                        String guestId = InputHelper.readString("Guest ID: ");
                        int roomNumber = InputHelper.readInt("Room No: ");
                        LocalDate in = LocalDate.parse(InputHelper.readString("Check-In Date (YYYY-MM-DD): "));
                        LocalDate out = LocalDate.parse(InputHelper.readString("Check-Out Date (YYYY-MM-DD): "));
                        double advance = InputHelper.readDouble("Advance Payment: ");
                        hotel.bookRoom(guestId, roomNumber, in, out,advance);
                        System.out.println("Room booked successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    int roomNo = InputHelper.readInt("Enter room number: ");
                    boolean checkout = hotel.checkout(roomNo);
                    System.out.println((checkout)?"Checked out successfully.":"Room Not Booked");
                    break;
                case 5:
                    hotel.showGuests();
                    // hotel.showGuests2();
                break;
                case 6:
                    hotel.showBookings();
                        break;
                case 7:
                    hotel.billings();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}