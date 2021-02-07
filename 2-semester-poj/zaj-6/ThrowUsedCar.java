/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;

public class ThrowUsedCar {

    public static void main(String[] args) {
        ArrayList<UsedCar> cars = new ArrayList<UsedCar>();

        try { // Bad vin
            cars.add(new UsedCar(12345, "Ford", 2000, 123, 321));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { // Bad year
            cars.add(new UsedCar(1234, "Honda", 2020, 123, 321));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try { // Bad make
            cars.add(new UsedCar(1234, "Audi", 2000, 123, 321));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cars.add(new UsedCar(1234, "Toyota", 2000, 123, 321));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cars.add(new UsedCar(1234, "Chrysler", 2000, 123, 321));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cars.add(new UsedCar(1234, "Other", 2000, 123, 321));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cars.add(new UsedCar(1234, "Toyota", 2000, 123, 321));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (UsedCar car : cars) {
            System.out.println(car);
        }
    }

}
