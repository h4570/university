/* Author: Sandro Sobczyński */

package com.company;

public class Rectangle {

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    private double width;
    private double height;

    public double getArea() {
        return width * height;
    }

    public double getCircuit() {
        return 2 * width + 2 * height;
    }

    public double getDiagonal() {
        return Math.pow(width, 2) + Math.pow(height, 2);
    }

}
