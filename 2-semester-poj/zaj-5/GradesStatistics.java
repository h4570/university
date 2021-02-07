/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class GradesStatistics {

    private ArrayList<Integer> grades;

    public GradesStatistics(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public String gradesInString() {
        return this.grades.toString();
    }

    public double getAverage() {
        return getSum() / grades.size();
    }

    public double getMedian() {
        Collections.sort(grades);
        int middle = grades.size() / 2;
        middle = middle > 0 && middle % 2 == 0 ? middle - 1 : middle;
        // 4/2 -> offset - 1 -> 1
        // 5/2 -> 2
        return grades.get(middle);
    }

    public int getMinimum() {
        return Collections.min(grades);
    }

    public int getMaximum() {
        return Collections.max(grades);
    }

    public double getStandardDeviation() {
        double result = 0.0;
        double mean = getSum() / grades.size();
        for (double num : grades) {
            result += Math.pow(num - mean, 2);
        }
        result = Math.sqrt(result / grades.size());
        return result;
    }

    private double getSum() {
        int result = 0;
        for (int i = 0; i < grades.size(); i++)
            result += grades.get(i);
        return result;
    }

}
