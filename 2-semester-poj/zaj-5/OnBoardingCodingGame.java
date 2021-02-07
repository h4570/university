/* Author: Sandro Sobczyński */

package com.company;

import java.util.*;

class Player {

    public static void main(String args[]) {

        /**
         * CodinGame planet is being attacked by slimy insectoid aliens. <--- Hint:To
         * protect the planet, you can implement the pseudo-code provided in the
         * statement, below the player.
         **/
        Scanner in = new Scanner(System.in);

        // Before your turn is over (end of the loop), output the value of either enemy1
        // or enemy2 to shoot the closest enemy.

        // game loop
        while (true) {
            String enemy1 = in.next(); // name of enemy 1
            int dist1 = in.nextInt(); // distance to enemy 1
            String enemy2 = in.next(); // name of enemy 2
            int dist2 = in.nextInt(); // distance to enemy 2

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            // You have to output a correct ship name to shoot ("Buzz", enemy1, enemy2, ...)

            /*
             * Solution below
             */
            if (dist1 > dist2) {
                System.out.println(enemy2);
            } else {
                System.out.println(enemy1);
            }
        }
    }
}