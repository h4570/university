/* Kcal calculator
Author: Sandro Sobczyński
 */
package com.company;

import java.util.Scanner;

public class Kcal {

    public static void main(String[] args) {
        double weight, height;
        int age;
        try {
            weight = getDoubleFromUser("Please enter your weight (kg): ");
            height = getDoubleFromUser("Please enter your height (cm): ");
            age = getIntFromUser("Please enter your age: ");
        } catch (Exception ex) {
            System.out.print("Please enter valid number next time!");
            return;
        }
        var harrBenedict = 66.47F + 13.7F * weight + 5.0F * height - 6.76F * (double) age;
        System.out.print(String.format("You need %.0f kcal every day", harrBenedict));
    }

    private static double getDoubleFromUser(String text) {
        System.out.print(text);
        var scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static int getIntFromUser(String text) {
        System.out.print(text);
        var scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
