/* Author: Sandro Sobczyński */

package com.company;

public class PizzaSpecial extends Pizza {

    private PizzaSize size;
    private boolean isAvailableForStudentDiscount;
    private boolean isUltraCheap;

    public PizzaSpecial(double calories, String name, double price) {
        super(calories, name, price);
    }

    public PizzaSpecial(double calories, String name, double price, PizzaSize size,
            boolean isAvailableForStudentDiscount, boolean isUltraCheap) {
        super(calories, name, price);
        this.size = size;
        this.isAvailableForStudentDiscount = isAvailableForStudentDiscount;
        this.isUltraCheap = isUltraCheap;
    }

    public PizzaSize getSize() {
        return size;
    }

    public boolean isAvailableForStudentDiscount() {
        return isAvailableForStudentDiscount;
    }

    public boolean isUltraCheap() {
        return isUltraCheap;
    }

}
