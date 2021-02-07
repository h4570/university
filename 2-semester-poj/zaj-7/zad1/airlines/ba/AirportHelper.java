/* Author: Sandro Sobczyński */

package com.company.zad1.airlines.ba;

public class AirportHelper {

    public static Airport getAirportByString(String name) throws Exception {
        Airport result = new Airport();
        switch (name) {
            case "GD":
                result.airportCode = "GD";
                break;
            case "WAW":
                result.airportCode = "WAW";
                break;
            default:
                throw new Exception();
        }
        return result;
    }

}
