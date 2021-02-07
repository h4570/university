/* Author: Sandro Sobczyński */

package com.company;

public abstract class Insurance {

    public Insurance(String type) {
        this.type = type;
    }

    protected String type;
    protected double monthlyPrice;

    public String getType() {
        return this.type;
    }

    public double getMonthlyPrice() {
        return this.monthlyPrice;
    }

    public abstract void setCost();

    public abstract void display();

}
