/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class MovablePoint implements Movable {

    int x = 0;
    int y = 0;
    int xSpeed = 1;
    int ySpeed = 1;

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString() {
        return String.format(Locale.US, "MovablePoint[x=%d, y=%d]", x, y);
    }

    @Override
    public void moveUp() {
        this.y += ySpeed;
    }

    @Override
    public void moveDown() {
        this.y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x -= xSpeed;
    }

    @Override
    public void moveRight() {
        this.x += xSpeed;
    }

}
