package com.example.notification;

import java.util.concurrent.*;

public class RealtimeNotificationSystem {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable email = () ->
                System.out.println("Email sent by "
                        + Thread.currentThread().getName());

        Runnable sms = () ->
                System.out.println("SMS sent by "
                        + Thread.currentThread().getName());

        for(int i=1;i<=5;i++) {
            executor.submit(email);
            executor.submit(sms);
        }

        executor.shutdown();
    }
}