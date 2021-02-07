/* Author: Sandro Sobczyński */

package com.company;

public class PizzaWoogy extends Pizza {

    private PizzaSize size;
    private boolean isAvailableForStudentDiscount;
    private boolean isFromTrash;

    public PizzaWoogy(double calories, String name, double price) {
        super(calories, name, price);
    }

    public PizzaWoogy(double calories, String name, double price, PizzaSize size, boolean isAvailableForStudentDiscount,
            boolean isFromTrash) {
        super(calories, name, price);
        this.size = size;
        this.isAvailableForStudentDiscount = isAvailableForStudentDiscount;
        this.isFromTrash = isFromTrash;
    }

    public PizzaSize getSize() {
        return size;
    }

    public boolean isAvailableForStudentDiscount() {
        return isAvailableForStudentDiscount;
    }

    public boolean isFromTrash() {
        return isFromTrash;
    }

}
