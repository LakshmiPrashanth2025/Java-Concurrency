package com.example.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> users =
                new ConcurrentHashMap<>();

        users.put(1, "Alice");
        users.put(2, "Bob");

        users.forEach((k, v) ->
                System.out.println(k + " " + v));
    }
}
