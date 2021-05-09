package pl.pjatk.sansob.movies.services;

import org.springframework.stereotype.Service;
import pl.pjatk.sansob.movies.enums.Category;
import pl.pjatk.sansob.movies.models.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final List<Movie> movies;

    public MovieService() {
        this.movies = new ArrayList<>();
        this.movies.add(new Movie(1, "Harry Potter", Category.Fantasy));
    }

    public List<Movie> getAll() {
        return this.movies;
    }

    public Optional<Movie> getById(Integer id) {
        return this.movies
                .stream()
                .filter(c -> c.getId().equals(id))
                .findAny();
    }

}
