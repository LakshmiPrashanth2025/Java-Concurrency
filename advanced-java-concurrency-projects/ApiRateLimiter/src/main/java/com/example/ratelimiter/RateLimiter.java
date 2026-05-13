package com.example.ratelimiter;

import java.util.concurrent.Semaphore;

public class RateLimiter {
    private final Semaphore semaphore;

    public RateLimiter(int limit) {
        semaphore = new Semaphore(limit);
    }

    public void accessApi(String client) {
        try {
            semaphore.acquire();
            System.out.println(client + " accessing API");
            Thread.sleep(1000);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}