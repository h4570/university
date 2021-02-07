/* Author: Sandro Sobczyński */

import java.util.*;
import java.io.*;
import java.math.*;

class CodPlayeringGameTheDescent {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {

            int highestMountainOffset = 0;
            int highestMountainHeight = 0;

            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                if (mountainH > highestMountainHeight) {
                    highestMountainHeight = mountainH;
                    highestMountainOffset = i;
                }
            }

            System.out.println(highestMountainOffset);

        }
    }
}