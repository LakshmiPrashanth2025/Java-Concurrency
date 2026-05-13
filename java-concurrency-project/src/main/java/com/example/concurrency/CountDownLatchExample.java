package com.example.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args)
            throws InterruptedException {

        CountDownLatch latch =
                new CountDownLatch(3);

        Runnable service = () -> {
            System.out.println("Service Started");
            latch.countDown();
        };

        new Thread(service).start();
        new Thread(service).start();
        new Thread(service).start();

        latch.await();

        System.out.println("All Services Ready");
    }
}
