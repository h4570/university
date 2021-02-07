/* Author: Sandro Sobczyński */

package com.company;

public class ResizableCircle extends Circle implements Resizable {

    public ResizableCircle(double radius) {
        super(radius);
    }

    public void resize(int percent) {
        this.setRadius((this.getRadius() / 100) * (100 - percent));
    }

}
