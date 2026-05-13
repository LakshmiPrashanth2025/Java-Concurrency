package com.example.concurrency;

class SMSService implements Runnable {
    @Override
    public void run() {
        System.out.println("Sending SMS...");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread t = new Thread(new SMSService());
        t.start();
    }
}