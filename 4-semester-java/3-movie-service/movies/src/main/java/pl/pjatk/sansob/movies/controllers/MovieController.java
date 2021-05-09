package pl.pjatk.sansob.movies.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.sansob.movies.models.Movie;
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
    public ResponseEntity<Movie> getById(@PathVariable Integer id) {
        var found = movieService.getById(id);
        if (found.isPresent()) {
            return ResponseEntity.ok(found.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if(movie.getId() < 0){ // or any other property issue
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(movie);
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
        var found = movieService.getById(id);
        if (found.isPresent()) {
            found.get().setFrom(movie);
            // Update in db
            return ResponseEntity.ok(found.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        var found = movieService.getById(id);
        if (found.isPresent()) {
            // Delete from db
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
