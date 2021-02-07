/* Author: Sandro Sobczyński */

package com.company;

public class PizzaDeluxe extends Pizza {

    private PizzaSize size;
    private boolean isAvailableForStudentDiscount;
    private boolean isPoisoning;

    public PizzaDeluxe(double calories, String name, double price) {
        super(calories, name, price);
    }

    public PizzaDeluxe(double calories, String name, double price, PizzaSize size,
            boolean isAvailableForStudentDiscount, boolean isPoisoning) {
        super(calories, name, price);
        this.size = size;
        this.isAvailableForStudentDiscount = isAvailableForStudentDiscount;
        this.isPoisoning = isPoisoning;
    }

    public PizzaSize getSize() {
        return size;
    }

    public boolean isAvailableForStudentDiscount() {
        return isAvailableForStudentDiscount;
    }

    public boolean isPoisoning() {
        return isPoisoning;
    }

}
