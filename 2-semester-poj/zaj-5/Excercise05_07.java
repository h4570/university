/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Excercise05_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        ArrayList<Integer> grades = new ArrayList<Integer>();
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print(String.format(Locale.US, "Enter the grade for student %d: ", i + 1));
            int grade = scanner.nextInt();
            grades.add(grade);
        }
        scanner.close();
        GradesStatistics statistics = new GradesStatistics(grades);
        String gradesInString = statistics.gradesInString();
        System.out.println(String.format(Locale.US, "The grades are: %s", gradesInString));
        double average = statistics.getAverage();
        System.out.println(String.format(Locale.US, "The average is: %.2f", average));
        double median = statistics.getMedian();
        System.out.println(String.format(Locale.US, "The median is: %.2f", median));
        int minimum = statistics.getMinimum();
        System.out.println(String.format(Locale.US, "The minimum is: %d", minimum));
        int maximum = statistics.getMaximum();
        System.out.println(String.format(Locale.US, "The maximum is: %d", maximum));
        double standardDeviation = statistics.getStandardDeviation();
        System.out.println(String.format(Locale.US, "The standard deviation is: %.2f", standardDeviation));
    }

}
