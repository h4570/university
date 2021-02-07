/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class Square extends Rectangle {

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square() {
        super();
    }

    public double getSide() {
        return this.getWidth();
    }

    public void setSide(double side) {
        this.setWidth(side);
        this.setHeight(side);
    }

    public void setHeight(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    public void setWidth(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    public String toString() {
        return String.format(Locale.US, "Square[Rectangle[Shape[color=%s,filled=%s],width=%.2f,height=%.2f]]",
                this.getColor(), this.isFilled(), this.getWidth(), this.getHeight());
    }

}