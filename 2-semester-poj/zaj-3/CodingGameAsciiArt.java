/* Author: Sandro Sobczyński */

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        in.nextLine();
        int height = in.nextInt();
        in.nextLine();
        String output = in.nextLine().toUpperCase();

        String rows = "";

        for (int i = 0; i < height; i++)
            rows += in.nextLine();

        String result = "";
        for (int row = 0; row < height; row++) {
            for (char character : output.toCharArray()) {
                int position = character < 65 || character > 90 ? 26 : character - 65;
                int start = (width * 27) * row + position * width;
                result += rows.substring(start, start + width);
            }
            result += "\n";
        }

        System.out.println(result);
    }
}
