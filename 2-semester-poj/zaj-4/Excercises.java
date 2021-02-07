/* Author: Sandro Sobczyński */

package com.company;

public class Excercises {

    public static void main(String[] args) {
        System.out.print("\n--- Excercise 20 ---\n\n");
        Excercise20();
        System.out.print("\n--- Excercise 21 ---\n\n");
        Excercise21();
        System.out.print("\n--- Excercise 22 ---\n\n");
        Excercise22();
        System.out.print("\n--- Excercise 23 ---\n\n");
        Excercise23();
    }

    private static void Excercise20() {
        Student maciek = new Student("Maciek", "Gdansk", "prg", 2020, 100.5F);
        Staff pjatk = new Staff("Grupa", "Gdansk", "PJATK", 999.2F);
        System.out.println(maciek.toString());
        System.out.println(pjatk.toString());
    }

    private static void Excercise21() {
        Point3D point = new Point3D(1, 2, 3);
        Point3D point2 = new Point3D();
        System.out.println(point.toString());
        System.out.println(point2.toString());
    }

    private static void Excercise22() {
        MovablePoint point = new MovablePoint(1, 2, 10, 20);
        System.out.println(point.toString());
    }

    private static void Excercise23() {
        Circle circle = new Circle();
        Rectangle rect = new Rectangle();
        Square sq = new Square();
        System.out.println(circle.toString());
        System.out.println(rect.toString());
        System.out.println(sq.toString());
    }

}
