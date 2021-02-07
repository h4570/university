/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

class Shape {

    private String color;
    private boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape() {
        color = "red";
        filled = true;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return String.format(Locale.US, "Shape[color=%s,filled=%s]", this.getColor(), this.isFilled());
    }

}