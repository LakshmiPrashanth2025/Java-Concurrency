package com.example.concurrency;

class EmailThread extends Thread {
    @Override
    public void run() {
        System.out.println("Sending Email...");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        EmailThread t1 = new EmailThread();
        t1.start();
    }
}