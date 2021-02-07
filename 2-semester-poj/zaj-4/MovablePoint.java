/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class MovablePoint extends Point {

    private float xSpeed;
    private float ySpeed;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        super();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
        super();
    }

    public float getXSpeed() {
        return this.xSpeed;
    }

    public void setXSpeed(float value) {
        this.xSpeed = value;
    }

    public float getYSpeed() {
        return this.ySpeed;
    }

    public void setYSpeed(float value) {
        this.ySpeed = value;
    }

    public float[] getSpeed() {
        float[] result = { this.getXSpeed(), this.getYSpeed() };
        return result;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.setXSpeed(xSpeed);
        this.setYSpeed(ySpeed);
    }

    public String toString() {
        return String.format(Locale.US, "(%.2f,%.2f),speed=(%.2f,%.2f)", this.getX(), this.getY(), this.getXSpeed(),
                this.getYSpeed());
    }

    public MovablePoint move() {
        this.setX(this.getX() + this.xSpeed);
        this.setY(this.getY() + this.ySpeed);
        return this;
    }

}