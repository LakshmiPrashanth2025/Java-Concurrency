package com.example.payment;

import java.util.concurrent.locks.ReentrantLock;

public class PaymentProcessor {

    private final ReentrantLock lock = new ReentrantLock();

    public void processPayment(String user, double amount) {

        lock.lock();

        try {
            System.out.println(user + " paid " + amount);
            Thread.sleep(500);
            System.out.println("Payment Successful for " + user);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}