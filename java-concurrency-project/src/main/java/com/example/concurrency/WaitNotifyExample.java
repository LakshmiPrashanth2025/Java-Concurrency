package com.example.concurrency;

class Restaurant {

    private boolean foodReady = false;

    public synchronized void prepareFood() throws InterruptedException {
        Thread.sleep(2000);
        foodReady = true;
        System.out.println("Food Prepared");

        notify();
    }

    public synchronized void deliverFood() throws InterruptedException {

        while (!foodReady) {
            wait();
        }
        System.out.println("Food Delivered");
    }
}

//Producer Consumer Example
public class WaitNotifyExample {

    public static void main(String[] args) {

        Restaurant r = new Restaurant();

        new Thread(() -> {
            try {
                r.prepareFood();
            } catch (Exception e) {
            }
        }).start();

        new Thread(() -> {
            try {
                r.deliverFood();
            } catch (Exception e) {
            }
        }).start();
    }
}
