package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends BaseRepository<Movie, Long> {

    @Query(value = "select m from Movie m " +
            "join m.users u " +
            "where m.genre = :genre and u.id <> :userId")
    List<Movie> getMoviesByGenre(@Param(value = "genre") String genre,
                                 @Param(value = "userId") Long userId);
}
