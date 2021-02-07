/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;

public class DemoTurners2 {

    public static void main(String[] args) {
        ArrayList<Turner> turners = new ArrayList<>();
        turners.add(new Leaf());
        turners.add(new Page());
        turners.add(new Pancake());
        turners.add(new Wheel());
        turners.add(new Bottle());
        for (Turner turner : turners) {
            turner.turn();
        }
    }

}
