package pl.pjatk.sansob.models;

public class Car {

    private final String model;
    private final String make;
    private final int year;

    public Car(String make,String model,int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

}
