/* Author: Sandro Sobczyński */

package com.company;

public class Account {

    private String id;
    private String name;
    private int balance;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public int credit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    public int debit(int amount) {
        if (amount <= balance)
            this.balance -= amount;
        else
            System.out.println("Amount exceeded balance");
        // throw new AmountExceededBalanceException("Given debit amount is incorrent for
        // this account.");
        return this.balance;
    }

    public int transferTo(Account another, int amount) {
        // debit(amount);
        // another.balance += amount;
        if (amount <= balance) {
            this.balance -= amount;
            another.balance += amount;
        } else
            System.out.println("Amount exceeded balance");
        return this.balance;
    }

    public String toString() {
        return String.format("Account[id=%s,name=%s,balance=%d]", this.getId(), this.getName(), this.getBalance());
    }

}

// class AmountExceededBalanceException extends Exception {
// private static final long serialVersionUID = 8432350015992304716L;
// AmountExceededBalanceException(String s) { super(s); }
// }