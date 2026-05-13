package com.example.banking;

public class BankingTransactionSystem {

    public static void main(String[] args) throws Exception {

        Account john = new Account("ACC1001", "John", 5000);
        Account alice = new Account("ACC1002", "Alice", 3000);

        Thread t1 = new Thread(() -> john.transfer(alice, 1000));
        Thread t2 = new Thread(() -> john.withdraw(500));
        Thread t3 = new Thread(() -> alice.deposit(2000));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        john.printStatement();
        alice.printStatement();
    }
}