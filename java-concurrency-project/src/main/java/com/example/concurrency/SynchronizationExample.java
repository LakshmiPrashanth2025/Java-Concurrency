package com.example.concurrency;

class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " Withdrawn: " + amount);
        }
    }
}

public class SynchronizationExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable task = () -> account.withdraw(500);

        new Thread(task, "User-1").start();
        new Thread(task, "User-2").start();
    }
}