/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        super();
        this.width = 1.0F;
        this.height = 1.0F;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return 2.0F * height + 2.0F * width;
    }

    public String toString() {
        return String.format(Locale.US, "Rectangle[Shape[color=%s,filled=%s],width=%.2f,height=%.2f]", this.getColor(),
                this.isFilled(), this.getWidth(), this.getHeight());
    }

}