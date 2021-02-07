/* Author: Sandro Sobczyński */

package com.company;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        String result = "";
        byte[] bytes = MESSAGE.getBytes();

        for (int i = 0; i < MESSAGE.length(); i++) {
            String temp = Integer.toBinaryString(bytes[i]);
            while (temp.length() < 7)
                temp = "0" + temp;
            result += temp;
        }

        int offset = 0;
        char currChar;
        while (offset < result.length()) {
            if (result.charAt(offset) != '0') {
                currChar = '1';
                System.out.print("0 ");
            } else {
                currChar = '0';
                System.out.print("00 ");
            }

            while (result.charAt(offset) == currChar) {
                offset++;
                System.out.print("0");
                if (offset == result.length())
                    break;
            }

            if (offset < result.length())
                System.out.print(" ");
        }
    }
}