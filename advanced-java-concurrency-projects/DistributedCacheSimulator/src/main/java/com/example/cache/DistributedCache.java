package com.example.cache;

import java.util.concurrent.*;

public class DistributedCache {

    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        cache.put(key, value);
        System.out.println("PUT -> " + key);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
        System.out.println("REMOVED -> " + key);
    }

    public void displayCache() {
        System.out.println(cache);
    }
}