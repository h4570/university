/* Bmi calculator
Author: Sandro Sobczyński
 */
package com.company;

import java.util.Scanner;

public class Bmi {

    public static void main(String[] args) {
        double weight, height;
        try {
            weight = getDoubleFromUser("Please enter your weight (kg): ");
            height = getDoubleFromUser("Please enter your height (cm): ");
        } catch (Exception ex) {
            System.out.print("Please enter valid number next time!");
            return;
        }
        var bmi = weight / Math.pow(height / 100, 2);
        var type = getBmiType(bmi);
        System.out.print(String.format("Your BMI: %.2f this is a %s", bmi, type));
    }

    private static double getDoubleFromUser(String text) {
        System.out.print(text);
        var scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static String getBmiType(double bmi) {
        if (bmi < 18.5) return "underweight";
        else if (bmi < 25) return "standard";
        else if (bmi < 30) return "overweight";
        else return "obesity";
    }

}
