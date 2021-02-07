/* Author: Sandro Sobczyński */

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int temp = 0;

        for (int i = 0; i < n; i++) {
            int t = in.nextInt();

            if (i == 0) {
                temp = t;
            }

            if (Math.abs(temp) > Math.abs(t)) {
                temp = t;
            } else if (Math.abs(temp) == Math.abs(t))
                if (t > temp)
                    temp = t;
        }

        System.out.println(temp);

    }
}
