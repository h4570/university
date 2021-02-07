/* Author: Sandro Sobczyński */

package com.company;

public class Invoice {

    private final int ID;
    private Customer customer;
    private double amount;

    public Invoice(int ID, Customer customer, double amount) {
        this.ID = ID;
        this.customer = customer;
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer value) {
        this.customer = value;
    }

    public String getAmount() {
        return String.valueOf(amount);
    }

    public void setAmount(double value) {
        this.amount = value;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public double getAmountAfterDiscount() {
        return amount - ((customer.getDiscount() / 100.0) * amount);
    }

}
