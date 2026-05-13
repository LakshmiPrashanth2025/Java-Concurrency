package com.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int task = i;
            executor.submit(() ->
                    System.out.println("Processing Task " + task));
        }

        executor.shutdown();
    }
}