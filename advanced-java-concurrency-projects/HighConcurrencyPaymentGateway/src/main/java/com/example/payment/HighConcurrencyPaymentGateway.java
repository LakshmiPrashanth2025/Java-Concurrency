package com.example.payment;

public class HighConcurrencyPaymentGateway {

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        Runnable task = () ->
                processor.processPayment(
                        Thread.currentThread().getName(), 1000);

        for(int i=1;i<=20;i++) {
            new Thread(task, "User-" + i).start();
        }
    }
}