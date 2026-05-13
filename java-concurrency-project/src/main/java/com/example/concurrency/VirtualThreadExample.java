package com.example.concurrency;

public class VirtualThreadExample {

    public static void main(String[] args)
            throws Exception {

        Runnable task = () ->
                System.out.println("Virtual Thread: "
                        + Thread.currentThread());

        Thread.startVirtualThread(task);

        Thread.sleep(1000);
    }
}