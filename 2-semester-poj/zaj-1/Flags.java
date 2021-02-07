/* Print Polish and Japan flag
Author: Sandro Sobczyński
 */
package com.company;

import java.util.Scanner;

public class Flags {

    public enum FlagSize {Small, Medium, Large}

    public static void main(String[] args) {
        System.out.print("Please choose 1 for small flags, 2 for medium or 3 for large flags: ");
        var flagSize = getFlagSize();
        if (flagSize != null) {
            drawPolishFlag(flagSize);
            System.out.print("\n---\n\n"); // Odstęp
            drawJapanFlag(flagSize);
        } else System.out.print("Incorrect size");
    }

    private static FlagSize getFlagSize() {
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        switch (input) {
            case "1":
                return FlagSize.Small;
            case "2":
                return FlagSize.Medium;
            case "3":
                return FlagSize.Large;
            default:
                return null;
        }
    }

    private static void drawPolishFlag(FlagSize size) {
        var numberSize = getNumberSize(size);

        for (int i = 0; i < numberSize / 6; i++) {
            for (int x = 0; x < numberSize; x++)
                System.out.print("`");
            System.out.println();
        }

        for (int i = 0; i < numberSize / 6; i++) {
            for (int x = 0; x < numberSize; x++)
                System.out.print("*");
            System.out.println();
        }
    }

    private static void drawJapanFlag(FlagSize size) {
        var numberSize = getNumberSize(size);

        for (int i = 1; i < numberSize / 8; i++) { // Góra flagi
            for (int x = 0; x < numberSize; x++)
                System.out.print("-");
            System.out.println();
        }

        for (int i = 2; i < numberSize / 4; i++) { // Pseudo kółko w środku
            for (int x = 0; x < numberSize; x++) {
                if (i <= numberSize / 8) {
                    if (x > (numberSize / 2) - ((numberSize / 6) + i) && x < (numberSize / 2) + ((numberSize / 6) + i))
                        System.out.print("*");
                    else
                        System.out.print("-");
                } else {
                    if (x > (numberSize / 2) - ((numberSize / 2) - i - 1) && x < (numberSize / 2) + ((numberSize / 2) - i - 1))
                        System.out.print("*");
                    else
                        System.out.print("-");
                }
            }
            System.out.println();
        }

        for (int i = 1; i < numberSize / 8; i++) { // Dół flagi
            for (int x = 0; x < numberSize; x++)
                System.out.print("-");
            System.out.println();
        }
    }

    private static int getNumberSize(FlagSize size) {
        switch (size) {
            case Small:
                return 16;
            case Medium:
                return 24;
            case Large:
                return 36;
        }
        return -1;
    }

}
