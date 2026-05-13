package com.example.url;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class UrlShortenerConcurrentCounter {

    private static final AtomicInteger counter = new AtomicInteger();
    private static final ConcurrentHashMap<String, Integer> hits =
            new ConcurrentHashMap<>();

    public static void shorten(String url) {
        int id = counter.incrementAndGet();
        hits.put(url, 0);
        System.out.println("Short URL-" + id + " created");
    }

    public static void access(String url) {
        hits.compute(url, (k,v) -> v + 1);
    }

    public static void main(String[] args) throws Exception {

        shorten("google.com");

        Runnable task = () -> access("google.com");

        for(int i=1;i<=10;i++) {
            new Thread(task).start();
        }

        Thread.sleep(2000);

        System.out.println(hits);
    }
}