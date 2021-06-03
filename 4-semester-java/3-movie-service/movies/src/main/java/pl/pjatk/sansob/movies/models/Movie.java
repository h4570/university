package pl.pjatk.sansob.movies.models;

import pl.pjatk.sansob.movies.enums.Category;

import javax.persistence.*;

@Entity()
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private boolean isAvailable;

    public Movie(){

    }

    public Movie(Long id, String name, Category category, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = available;
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
    public boolean isAvailable() { return isAvailable;}

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setIsAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    public void setFrom(Movie movie) {
        this.setName(movie.name);
        this.setCategory(movie.category);
        this.setIsAvailable(movie.isAvailable);
    }

}
