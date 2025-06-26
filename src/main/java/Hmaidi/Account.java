package Hmaidi;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Account {
    private static class Transaction {
        String date;
        int amount;
        int balance;

         Transaction(String date, int amount, int balance) {
            this.date = date;
            this.amount = amount;
            this.balance = balance;
        }
    }

    private final List<Transaction> transactions = new ArrayList<>();
    int balance = 0;


    public void deposit(int amount, String date) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        else {
            balance += amount;
            transactions.add(new Transaction(date,amount,balance));
        }
    }

    public void withdraw(int amount, String date) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        } else if (amount > balance){
            throw new IllegalArgumentException("Amount must be less than balance");
        } else {
            balance -= amount;
            transactions.add(new Transaction(date,amount,balance));
        }
    }

    public void printStatement() {
        System.out.println("DATE       | AMOUNT | BALANCE");
        ListIterator<Transaction> it = transactions.listIterator(transactions.size());
        while (it.hasPrevious()) {
            Transaction t = it.previous();
            System.out.printf("%s | %d | %d%n", t.date, t.amount, t.balance);
        }
    }


}
