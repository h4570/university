/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class Pizza implements Comparable<Pizza> {

    private double calories;
    private String name;
    private double price;

    public Pizza(double calories, String name, double price) {
        this.calories = calories;
        this.name = name;
        this.price = price;
    }

    public double getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Pizza pizza) {
        if (this.price == pizza.price)
            return 0;
        return this.price > pizza.price ? 1 : -1;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Pizza[calories=%.2f, name=%s, price=%.2f]", calories, name, price);
    }

}
