/* Author: Sandro Sobczyński */

package com.company;

import java.util.Arrays;

public class Excercise05_01 {

    public static void main(String[] args) {
        MyPoint[] points = new MyPoint[10];
        for (int i = 0; i < points.length; i++)
            points[i] = new MyPoint(i + 1, i + 1);
        String pointsStrings = Arrays.toString(points);
        System.out.println(pointsStrings);
    }

}
