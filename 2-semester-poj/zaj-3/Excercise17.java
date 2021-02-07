/* Author: Sandro Sobczyński */

package com.company;

public class Excercise17 {

    public static void main(String[] args) {
        printPalindromeStatus("Atak kata.");
        printPalindromeStatus("Muzo, raz daj jad za rozum.");
        printPalindromeStatus("Wódy żal dla żydów.");
        printPalindromeStatus("lolx,.");
    }

    private static void printPalindromeStatus(String text) {
        if (isPalindrome(text))
            System.out.println(String.format("%s is a palindrome", text));
        else
            System.out.println(String.format("%s is not a palindrome", text));
    }

    private static boolean isPalindrome(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--)
            reversed += text.charAt(i);
        reversed = reversed.toLowerCase().replaceAll(" ", "").replace(",", "").replace(".", "");
        text = text.toLowerCase().replaceAll(" ", "").replace(",", "").replace(".", "");
        return reversed.equals(text);
    }

}