/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class Point3D extends Point2D {

    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        super();
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float value) {
        this.z = value;
    }

    public float[] getXYZ() {
        float[] result = { this.getX(), this.getY(), this.getZ() };
        return result;
    }

    public void setXYZ(float x, float y, float z) {
        setXY(x, y);
        this.z = z;
    }

    public String toString() {
        return String.format(Locale.US, "(%.2f,%.2f,%.2f)", this.getX(), this.getY(), this.getZ());
    }

}