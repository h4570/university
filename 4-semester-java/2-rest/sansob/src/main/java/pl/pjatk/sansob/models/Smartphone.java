package pl.pjatk.sansob.models;

public class Smartphone {

    private final String model;
    private final int id;

    public Smartphone(int id, String model) {
        this.id = id;
        this.model = model;
    }

    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }

}
