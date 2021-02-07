/* Author: Sandro Sobczyński */

package com.company;

import java.util.Scanner;

public class UseInsurance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter:");
        System.out.println("1 - For life insurance");
        System.out.println("2 - For health insurance");
        System.out.print("> ");
        int choice = scanner.nextInt();
        scanner.close();
        Insurance insurance;
        switch (choice) {
            case 1:
                insurance = new Life();
                break;
            case 2:
                insurance = new Health();
                break;
            default:
                System.out.println("Wrong choice");
                return;
        }
        insurance.setCost();
        insurance.display();
    }

}
