package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "select t.id from Ticket t " +
            "where t.movie.id = :movieId")
    List<Ticket> findByMovieId(@Param(value = "movieId")
                               int movieId);
}
