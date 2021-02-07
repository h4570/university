/* Author: Sandro Sobczyński */

package com.company;

public class Excercise24 {

    public static void main(String[] args) {
        int test = 371;
        if (isArmstrongNumber(test)) {
            System.out.println(String.format("%d is a Armstrong number", test));
        } else {
            System.out.println(String.format("%d is not a Armstrong number", test));
        }
    }

    private static boolean isArmstrongNumber(int input) {
        char[] inputInChars = String.valueOf(input).toCharArray();
        int sum = 0;
        for (char char_ : inputInChars) {
            int charInInt = Integer.parseInt(String.valueOf(char_));
            int charSum = charInInt;
            for (int i = 0; i < inputInChars.length - 1; i++)
                charSum *= charInInt;
            sum += charSum;
        }
        return input == sum;
    }

}
