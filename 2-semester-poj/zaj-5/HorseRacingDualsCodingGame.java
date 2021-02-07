/* Author: Sandro Sobczyński */

package com.company;

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();
        ArrayList<Integer> racingHorses = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            int pi = in.nextInt();
            in.nextLine();
            racingHorses.add(pi);
        }
        Collections.sort(racingHorses);
        int gap = 1000;
        int temp = 0;
        for (int i = 0; i < racingHorses.size() - 1; i++) {
            temp = racingHorses.get(i + 1) - racingHorses.get(i);
            if (temp < gap) {
                gap = temp;
            }
        }
        System.out.println(gap);
    }
}
