package com.example.ratelimiter;

public class ApiRateLimiter {
    public static void main(String[] args) {

        RateLimiter limiter = new RateLimiter(3);

        Runnable task = () ->
                limiter.accessApi(Thread.currentThread().getName());

        for(int i=1;i<=10;i++) {
            new Thread(task, "Client-" + i).start();
        }
    }
}