/* Author: Sandro Sobczyński */

import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            String dir = "";

            if (initialTy > lightY) {
                dir = "N";
                initialTy--;
            } else if (initialTy < lightY) {
                dir = "S";
                initialTy++;
            }

            if (initialTx > lightX) {
                dir += "W";
                initialTx--;
            } else if (initialTx < lightX) {
                dir += "E";
                initialTx++;
            }

            System.out.println(dir);

        }
    }
}