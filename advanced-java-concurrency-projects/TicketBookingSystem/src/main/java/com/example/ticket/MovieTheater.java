package com.example.ticket;

import java.util.*;

public class MovieTheater {
    private final Set<Integer> bookedSeats = new HashSet<>();

    public synchronized boolean bookSeat(int seat, String user) {
        if(bookedSeats.contains(seat)) {
            System.out.println("Seat already booked: " + seat);
            return false;
        }
        bookedSeats.add(seat);
        System.out.println(user + " booked seat " + seat);
        return true;
    }

    public synchronized void cancelSeat(int seat, String user) {
        bookedSeats.remove(seat);
        System.out.println(user + " cancelled seat " + seat);
    }

    public synchronized void displaySeats() {
        System.out.println("Booked Seats: " + bookedSeats);
    }
}