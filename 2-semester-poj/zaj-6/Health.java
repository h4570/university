/* Author: Sandro Sobczyński */

package com.company;

public class Health extends Insurance {

    public Health() {
        super("Health");
    }

    @Override
    public void setCost() {
        this.monthlyPrice = 196;
    }

    @Override
    public void display() {
        System.out.println(String.format("%s insurance. Monthly price: %.2f", this.getType(), this.getMonthlyPrice()));
    }

}
