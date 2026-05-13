package com.example.ticket;

public class TicketBookingSystem {
    public static void main(String[] args) throws Exception {

        MovieTheater theater = new MovieTheater();

        Runnable bookingTask = () -> {
            theater.bookSeat(1, Thread.currentThread().getName());
        };

        Thread t1 = new Thread(bookingTask, "User-1");
        Thread t2 = new Thread(bookingTask, "User-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        theater.displaySeats();
    }
}