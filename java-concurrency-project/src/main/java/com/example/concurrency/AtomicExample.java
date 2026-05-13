package com.example.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    private static AtomicInteger counter =
            new AtomicInteger();

    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        };

        new Thread(task).start();
        new Thread(task).start();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println(counter.get());
    }
}