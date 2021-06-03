package pl.pjatk.sansob.movies.services;

import org.springframework.stereotype.Service;
import pl.pjatk.sansob.movies.models.Movie;
import pl.pjatk.sansob.movies.repositories.MovieRepository;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepo;

    public MovieService(MovieRepository repo) {
        this.movieRepo = repo;
    }

    public List<Movie> getAll() {
        return this.movieRepo.findAll();
    }

    public Movie getById(Long id) throws MovieNotFoundException {
        var dbMovieOpt = this.movieRepo.findById(id);
        if (!dbMovieOpt.isPresent())
            throw new MovieNotFoundException(String.format("Movie with id=%d was not found!", id));
        return dbMovieOpt.get();
    }

    public Movie add(Movie movie) {
        movie.setId(0L);
        return this.movieRepo.save(movie);
    }

    public Movie updateIsAvailable(Long id, boolean value) throws MovieNotFoundException {
        var dbMovie = getById(id);
        dbMovie.setIsAvailable(value);
        this.movieRepo.save(dbMovie);
        return dbMovie;
    }

    public Movie update(Movie movie) throws MovieNotFoundException {
        var dbMovie = getById(movie.getId());
        dbMovie.setFrom(movie); // category and name
        this.movieRepo.save(dbMovie);
        return dbMovie;
    }

    public void delete(Long id) throws MovieNotFoundException {
        var dbMovie = getById(id);
        this.movieRepo.deleteById(id);
    }

}
