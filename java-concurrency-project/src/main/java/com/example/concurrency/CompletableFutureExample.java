package com.example.concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {

            return "Order Data";

        }).thenApply(data -> {

            return data + " Processed";

        }).thenAccept(System.out::println);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
}