/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class MyPoint {

    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int value) {
        this.x = value;
    }

    public int getY() {
        return y;
    }

    public void setY(int value) {
        this.y = value;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXY() {
        return new int[] { x, y };
    }

    public String toString() {
        return String.format(Locale.US, "(%d, %d)", x, y);
    }

    public double distance(int x, int y) {
        return Math.sqrt((Math.pow((x - getX()), 2) + (Math.pow((y - getY()), 2))));
    }

    public double distance(MyPoint point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }

    public double distance() {
        return Math.sqrt((Math.pow(x, 2) + (Math.pow(y, 2))));
    }

}
