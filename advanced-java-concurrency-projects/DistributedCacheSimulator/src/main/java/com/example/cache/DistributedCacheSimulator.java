package com.example.cache;

public class DistributedCacheSimulator {
    public static void main(String[] args) throws Exception {

        DistributedCache cache = new DistributedCache();

        Thread writer = new Thread(() -> cache.put("user:1", "John"));
        Thread reader = new Thread(() ->
                System.out.println("Fetched: " + cache.get("user:1")));
        Thread remover = new Thread(() -> cache.remove("user:1"));

        writer.start();
        writer.join();

        reader.start();
        remover.start();

        reader.join();
        remover.join();

        cache.displayCache();
    }
}