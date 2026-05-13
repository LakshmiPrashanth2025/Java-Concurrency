package com.example.queue;

import java.util.concurrent.*;

public class ProducerConsumerQueue {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try {
                for(int i=1;i<=10;i++) {
                    String item = "Task-" + i;
                    queue.put(item);
                    System.out.println("Produced: " + item);
                }
            } catch(Exception e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                while(true) {
                    String item = queue.take();
                    System.out.println("Consumed: " + item);
                }
            } catch(Exception e) {}
        });

        producer.start();
        consumer.start();
    }
}