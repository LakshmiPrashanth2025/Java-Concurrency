package com.example.concurrency;

public class ThreadLifecycleExample {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread Running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.getState());

        t.start();

        System.out.println(t.getState());
    }
}
