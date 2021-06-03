package pl.pjatk.sansob.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.sansob.movies.models.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Override
    List<Movie> findAll();

    @Override
    Optional<Movie> findById(Long id);

    @Override
    <S extends Movie> S save(S s);

    @Override
    void delete(Movie movie);

}
