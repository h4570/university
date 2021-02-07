/* Pyramid drawer
Author: Sandro Sobczyński
 */
package com.company;

import java.util.Scanner;

public class Pyramid {

    public static void main(String[] args) {
        int size;
        System.out.print("Enter pyramid size: ");
        var scanner = new Scanner(System.in);
        try {
            size = scanner.nextInt();
            if (size < 0) throw new Exception();
        } catch (Exception ex) {
            System.out.print("Please enter valid number next time!");
            return;
        }
        drawPyramid(size);
    }

    public static void drawPyramid(int size) {
        for (int i = 0; i < size; i++) {
            drawPyramidLineSpaces(size, i);
            var text = getPyramidTextContent(i * 2);
            System.out.println(text);
        }
    }

    public static void drawPyramidLineSpaces(int size, int offset) {
        for (int i = 0; i < size - offset; i++)
            System.out.print(" ");
    }

    public static String getPyramidTextContent(int size) {
        char chars[] = {'a', 'b', 'c'};
        var latest = 2;
        var result = "";
        for (int i = 0; i <= size; i++) {
            latest = latest == 2 ? 0 : latest;
            result += chars[latest++];
        }
        return result;
    }

}
