package service;

import model.Booking;
import java.time.temporal.ChronoUnit;

public class BillingService {
    public double calculateBill(Booking booking) {
        long days = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
        return days * booking.getRoom().getPrice();
    }
}