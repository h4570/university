package pl.pjatk.sansob.rentalservice.models;

import pl.pjatk.sansob.rentalservice.enums.Category;

public class Movie {

    private Long id;
    private String name;
    private Category category;
    private boolean available;

    public Movie(){ }

    public Movie(Long id, String name, Category category, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAvailable() { return available;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setIsAvailable(boolean isAvailable) { this.available = isAvailable; }

    public void setFrom(Movie movie) {
        this.setName(movie.name);
        this.setCategory(movie.category);
        this.setIsAvailable(movie.available);
    }

}