package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TicketRepository extends BaseRepository<Ticket, Long> {

    @Transactional
    @Modifying
    @Query(value = "update Ticket t set t.refund = true " +
            "where t.user.id = :userId and t.id = :ticketId")
    double refundTicketByUserId(@Param(value = "userId") Long userId,
                              @Param(value = "ticketId") Long ticketId);

    @Query(value = "select t.id from Ticket t " +
            "where t.movie.id = :movieId")
    List<Ticket> findByMovieId(@Param(value = "movieId")
                               int movieId);

    @Query(value = "select t.user.bonusBalance from Ticket t " +
            "where t.user.id = :userId")
    double findBalanceByUserId(@Param(value = "userId")
                               Long userId);

}
