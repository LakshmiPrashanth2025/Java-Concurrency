package com.example.file;

import java.util.concurrent.*;

public class ParallelFileProcessingEngine {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=1;i<=5;i++) {
            int file = i;

            executor.submit(() -> {
                System.out.println("Reading File-" + file);
                try { Thread.sleep(1000); } catch(Exception e){}
                System.out.println("Processed File-" + file);
            });
        }

        executor.shutdown();
    }
}