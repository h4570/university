/* Author: Sandro Sobczyński */

package com.company;

public class Triangle {

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private double sideA;
    private double sideB;
    private double sideC;

    public double getCircuit() {
        return this.sideA + this.sideB + this.sideC;
    }

    public double getArea() {
        double halfCircuit = getCircuit() / 2;
        return Math.sqrt(
                halfCircuit * (halfCircuit - this.sideA) * (halfCircuit - this.sideB) * (halfCircuit - this.sideC));
    }

    public boolean isEquilateral() {
        return this.sideA == this.sideB && this.sideA == this.sideC;
    }

    public boolean isScalene() {
        return this.sideA != this.sideB && this.sideA != this.sideC && this.sideB != this.sideC;
    }

    public boolean isIsosceles() {
        return !isEquilateral() && (this.sideA == this.sideB || this.sideA == this.sideC || this.sideB == this.sideC);
    }

}
