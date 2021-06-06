package pl.pjatk.sansob.rentalservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.sansob.rentalservice.models.Movie;

import java.util.Optional;

@Service
public class MovieService {

    private final RestTemplate restTemplate;
    private final String url;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = "http://localhost:8080";
    }

    /**
     * Exception is thrown on (status != 2xx && status !== 404)
     */
    public Optional<Movie> getMovie(Long id) throws HttpClientErrorException {
        try {
            return Optional.of(this.restTemplate.getForObject(url + "/movies/" + id, Movie.class));
        } catch (final HttpClientErrorException e) {
            var statusCode = e.getStatusCode();
            if (statusCode.value() == 404)
                return Optional.empty();
            throw e;
        }
    }

    public void returnMovie(Long id) throws RestClientException {
        this.restTemplate.getForObject(url + "/movies/" + id+"/is-available/true", Movie.class);
    }

    public void rentMovie(Long id) throws RestClientException {
        this.restTemplate.getForObject(url + "/movies/" + id+"/is-available/false", Movie.class);
    }

}