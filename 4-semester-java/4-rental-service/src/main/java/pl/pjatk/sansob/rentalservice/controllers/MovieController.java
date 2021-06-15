package pl.pjatk.sansob.rentalservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.sansob.rentalservice.models.Movie;
import pl.pjatk.sansob.rentalservice.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(RestTemplate restTemplate) {
        this.movieService = new MovieService(restTemplate);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getById(@PathVariable Long id) {
        try {
            var res = movieService.getMovie(id);
            if (res.isPresent())
                return ResponseEntity.ok(res.get());
            else
                return ResponseEntity.notFound().build();
        } catch (HttpClientErrorException e) {
            return homework(e);
        }
    }

    @PatchMapping("{id}/return")
    public ResponseEntity return_(@PathVariable Long id) {
        try {
            movieService.returnMovie(id);
            return ResponseEntity.ok().build();
        } catch (HttpClientErrorException e) {
            return homework(e);
        }
    }

    @PatchMapping("{id}/rent")
    public ResponseEntity rent(@PathVariable Long id) {
        try {
            movieService.rentMovie(id);
            return ResponseEntity.ok().build();
        } catch (HttpClientErrorException e) {
            return homework(e);
        }
    }

    private ResponseEntity homework(HttpClientErrorException e) {
        switch (e.getStatusCode()) {
            case NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            case BAD_REQUEST:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            case INTERNAL_SERVER_ERROR:
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
            default:
                return ResponseEntity.status(504).build();
        }
    }

}