
/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class MyRectangle {

    private MyPoint topLeft;
    private MyPoint bottomRight;

    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double getWidth() {
        return topLeft.getY() - bottomRight.getY();
    }

    public double getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getWidth() + getLength());
    }

    public String toString() {
        return String.format(Locale.US, "MyRectangle[topLeft=%s, bottomRight=%s]", topLeft.toString(),
                bottomRight.toString());
    }

}