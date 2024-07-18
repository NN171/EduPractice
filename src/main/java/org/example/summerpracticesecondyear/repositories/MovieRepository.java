package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.Movie;
import org.example.summerpracticesecondyear.projections.MovieType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends BaseRepository<Movie, Long> {

    @Query(value = "select m.id as id, m.title as title, m.duration as duration, m.genre as genre from Movie m " +
            "where m.genre = :genre")
    List<MovieType> getMoviesByGenre(@Param(value = "genre")
                                 String genre);
}
