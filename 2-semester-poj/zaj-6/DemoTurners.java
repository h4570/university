/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;

public class DemoTurners {

    public static void main(String[] args) {
        ArrayList<Turner> turners = new ArrayList<>();
        turners.add(new Leaf());
        turners.add(new Page());
        turners.add(new Pancake());
        for (Turner turner : turners) {
            turner.turn();
        }
    }

}
