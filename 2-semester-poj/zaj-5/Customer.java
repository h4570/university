/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class Customer {

    private int ID;
    private String name;
    private int discount;

    public Customer(int ID, String name, int discount) {
        this.ID = ID;
        this.name = name;
        this.discount = discount;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int value) {
        this.discount = value;
    }

    public String toString() {
        return String.format(Locale.US, "name(%d)", ID);
    }

}