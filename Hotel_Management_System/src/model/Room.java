package model;

public class Room {
    private int roomNumber;
    private String type;
    private double price;
    private boolean isBooked;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isBooked() { return isBooked; }

    public void book() { this.isBooked = true; }
    public void vacate() { this.isBooked = false; }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + type + ") - ₹" + price + " - " + (isBooked ? "Booked" : "Available");
    }
}