package com.example.concurrency;

class StockPrice {

    volatile boolean updated = false;

    public void updatePrice() {
        updated = true;
    }
}

public class VolatileExample {

    public static void main(String[] args) {

        StockPrice stock = new StockPrice();

        new Thread(() -> {
            while (!stock.updated) {
            }

            System.out.println("Price Updated");
        }).start();

        new Thread(() -> {
            stock.updatePrice();
        }).start();
    }
}
