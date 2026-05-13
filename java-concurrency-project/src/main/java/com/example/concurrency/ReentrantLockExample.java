package com.example.concurrency;

import java.util.concurrent.locks.ReentrantLock;

class SeatBooking {

    private final ReentrantLock lock =
            new ReentrantLock();

    public void bookSeat() {

        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " booked seat");
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockExample {

    public static void main(String[] args) {

        SeatBooking booking = new SeatBooking();

        Runnable task = booking::bookSeat;

        new Thread(task).start();
        new Thread(task).start();
    }
}
