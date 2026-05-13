package com.example.banking;

import java.util.*;

public class Account {
    private final String accountNumber;
    private final String holderName;
    private double balance;
    private final List<String> statement = new ArrayList<>();

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        statement.add("Account opened with balance: " + balance);
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        statement.add("Deposited: " + amount);
    }

    public synchronized void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            statement.add("Withdrawn: " + amount);
        }
    }

    public synchronized void transfer(Account target, double amount) {
        if(balance >= amount) {
            balance -= amount;
            target.deposit(amount);
            statement.add("Transferred " + amount + " to " + target.accountNumber);
        }
    }

    public synchronized void printStatement() {
        System.out.println("Statement for " + holderName);
        statement.forEach(System.out::println);
        System.out.println("Balance: " + balance);
    }
}