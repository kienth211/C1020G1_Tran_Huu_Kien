package models.activities;

import models.person.Customer;
import models.services.House;
import models.services.Room;
import models.services.Villa;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    List<Booking> list;

    public BookingManager() {
        list = new ArrayList<>();
    }

    public void addNewBooking(Villa villa, Customer customer) {
        try {
            addNewBookingCheck(villa, customer);
        } catch (NullPointerException e) {
            list.remove(list.size() - 1);
            System.err.println("Service or customer not exist!");
        }
    }

    private void addNewBookingCheck(Villa villa, Customer customer) throws NullPointerException {
        Booking booking = new Booking(villa, customer);
        list.add(booking);
        writeBooking(booking);
    }

    public void addNewBooking(House House, Customer customer) {
        try {
            addNewBookingCheck(House, customer);
        } catch (NullPointerException e) {
            list.remove(list.size() - 1);
            System.err.println("Service or customer not exist!");
        }
    }

    private void addNewBookingCheck(House House, Customer customer) throws NullPointerException {
        Booking booking = new Booking(House, customer);
        list.add(booking);
        writeBooking(booking);
    }

    public void addNewBooking(Room Room, Customer customer) {
        try {
            addNewBookingCheck(Room, customer);
        } catch (NullPointerException e) {
            list.remove(list.size() - 1);
            System.err.println("Service or customer not exist!");
        }
    }

    private void addNewBookingCheck(Room Room, Customer customer) throws NullPointerException {
        Booking booking = new Booking(Room, customer);
        list.add(booking);
        writeBooking(booking);
    }

    private void writeBooking(Booking booking) {
        try {
            writeBookingCheck(booking);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeBookingCheck(Booking booking) throws IOException {
        BufferedWriter bufferedWriter = null;
        bufferedWriter = new BufferedWriter(
                new FileWriter("src/data/Booking.csv", true));
        bufferedWriter.write("+Booking+");
        bufferedWriter.newLine();
        bufferedWriter.write(booking.getCustomer().showInfo());
        bufferedWriter.newLine();
        bufferedWriter.write(booking.getServices().showInfo());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
