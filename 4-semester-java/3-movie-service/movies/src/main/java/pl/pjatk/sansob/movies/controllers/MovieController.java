package pl.pjatk.sansob.movies.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.sansob.movies.models.Movie;
import pl.pjatk.sansob.movies.services.MovieNotFoundException;
import pl.pjatk.sansob.movies.services.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(movieService.getById(id));
        } catch (MovieNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        var added = movieService.add(movie);
        return ResponseEntity.ok(added);
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
        try {
            var updated = movieService.update(movie);
            return ResponseEntity.ok(updated);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            movieService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (MovieNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}/is-available/{value}")
    public ResponseEntity<Movie> changeIsAvailable(@PathVariable Long id, @PathVariable(value = "value") boolean value) throws MovieNotFoundException {
        return ResponseEntity.ok(movieService.updateIsAvailable(id, value));
    }

}
