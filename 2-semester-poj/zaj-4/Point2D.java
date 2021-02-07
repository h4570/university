/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

class Point2D {

    private float x;
    private float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }

    public float getX() {
        return this.x;
    }

    public void setX(float value) {
        this.x = value;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float value) {
        this.y = value;
    }

    public float[] getXY() {
        float[] result = { x, y };
        return result;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format(Locale.US, "(%.2f,%.2f)", this.getX(), this.getY());
    }

}