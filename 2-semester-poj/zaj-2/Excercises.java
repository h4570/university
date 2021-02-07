/* Author: Sandro Sobczyński */

package com.company;

import com.company.HumanParameters.SexType;

public class Excercises {

    public static void main(String[] args) {
        System.out.print("--- Excercise 5 ---\n\n");
        Excercise5();
        System.out.print("\n--- Excercise 6 ---\n\n");
        Excercise6();
        System.out.print("\n--- Excercise 7 ---\n\n");
        Excercise7();
        System.out.print("\n--- Excercise 8 ---\n\n");
        Excercise8();
    }

    private static void Excercise5() {
        HumanParameters params = new HumanParameters();
        params.name = "Sandro";
        params.age = 21;
        params.feetSize = 23;
        params.height = 173;
        params.indexNumber = "s20600";
        params.sex = SexType.Male;
        params.weight = 76;

        Human sandro = new Human(params);
        if (sandro.isMale()) {
            System.out.println(sandro.getName());
        }
    }

    private static void Excercise6() {
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println(String.format("Area: %s", rectangle.getArea()));
        System.out.println(String.format("Circuit: %s", rectangle.getCircuit()));
        System.out.println(String.format("Diagonal: %s", rectangle.getDiagonal()));
    }

    private static void Excercise7() {
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println(String.format("Circuit: %s", triangle.getCircuit()));
        System.out.println(String.format("Area: %s", triangle.getArea()));
        System.out.println(String.format("isEquilateral: %s", triangle.isEquilateral()));
        System.out.println(String.format("isIsosceles: %s", triangle.isIsosceles()));
        System.out.println(String.format("isScalene: %s", triangle.isScalene()));
    }

    private static void Excercise8() {
        int offset = 28;
        String fullName = "Sandro Sobczyński";
        Caesar caesar = new Caesar(offset);
        String encrypted = caesar.encrypt(fullName);
        System.out.println(String.format("Original: %s, Encrypted: %s", fullName, encrypted));
    }

}