package pl.pjatk.sansob.movies.models;

import pl.pjatk.sansob.movies.enums.Category;

public class Movie {

    private  Integer id;
    private  String name;
    private  Category category;

    public Movie(Integer id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setFrom(Movie movie) {
        this.setId(movie.id);
        this.setName(movie.name);
        this.setCategory(movie.category);
    }

}
