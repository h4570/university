package pl.pjatk.sansob.movies.services;

import org.springframework.stereotype.Service;
import pl.pjatk.sansob.movies.enums.Category;
import pl.pjatk.sansob.movies.models.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final List<Movie> movies;

    public MovieService() {
        this.movies = new ArrayList<>();
        this.movies.add(new Movie(1L, "Harry Potter", Category.Fantasy));
    }

    public List<Movie> getAll() {
        return this.movies;
    }

    public Optional<Movie> getById(Long id) {
        return this.movies
                .stream()
                .filter(c -> c.getId().equals(id))
                .findAny();
    }

}
