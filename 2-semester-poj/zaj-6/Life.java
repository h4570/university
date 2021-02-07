/* Author: Sandro Sobczyński */

package com.company;

public class Life extends Insurance {

    public Life() {
        super("Life");
    }

    @Override
    public void setCost() {
        this.monthlyPrice = 36;
    }

    @Override
    public void display() {
        System.out.println(String.format("%s insurance. Monthly price: %.2f", this.getType(), this.getMonthlyPrice()));
    }

}
