package pl.pjatk.sansob.movies.services;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
