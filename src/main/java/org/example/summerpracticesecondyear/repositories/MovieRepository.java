package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends BaseRepository<Movie, Integer> {

    @Query(value = "select m.title from Movie m " +
            "where m.genre = :genre")
    List<String> getMovieByGenre(@Param(value = "genre")
                                 String genre);
}
