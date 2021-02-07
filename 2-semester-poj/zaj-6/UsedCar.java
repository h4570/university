/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class UsedCar {

    private int vin;
    private String make;
    private int year;
    private int mileage;
    private double price;

    public UsedCar(int vin, String make, int year, int mileage, double price) throws UsedCarException {
        if (Integer.toString(vin).length() != 4)
            throw new UsedCarException("VIN must have 4 digits");

        switch (make) {
            case "Ford":
            case "Honda":
            case "Toyota":
            case "Chrysler":
            case "Other":
                this.make = make;
                break;
            default:
                throw new UsedCarException("Wrong make");
        }

        if (year < 1997 || year > 2017)
            throw new UsedCarException("Car must be produced between 1997 and 2017 only");

        if (mileage < 0 || price < 0)
            throw new UsedCarException("Please check mileage and price fields");

        this.vin = vin;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "UsedCar[vin=%d, make=%s, year=%d, mileage=%d, price=%.2f]", vin, make, year,
                mileage, price);
    }
}