package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.Session;
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
            "where t.id = :ticketId")
    void refundTicketByTicketId(@Param(value = "ticketId")
                                         Long ticketId);

    @Query(value = "select t.refund from Ticket t " +
            "where t.id = :ticketId")
    boolean isRefundByTicketId(@Param("ticketId")
                               Long ticketId);

    @Query(value = "select t.session from Ticket t " +
            "where t.id = :ticketId")
    Session findSessionByTicketId(@Param(value = "ticketId")
                                  Long ticketId);

    @Query(value = "select t.user.id from Ticket t " +
            "where t.id = :ticketId")
    Long findUserByTicketId(@Param(value = "ticketId")
                      Long ticketId);

    @Query(value = "select t.user.id from Ticket t " +
            "where t.seat = :seat and " +
            "t.session.id = :sessionId and t.movie.id = :movieId")
    Long findUserIdForOrderingService(@Param(value = "seat") int seat,
                                      @Param(value = "sessionId") Long sessionId,
                                      @Param(value = "movieId") Long movieId);

    @Query(value = "select t.id from Ticket t " +
            "where t.seat = :seat and " +
            "t.session.id = :sessionId and t.movie.id = :movieId")
    Long findTicketIdForOrderingService(@Param(value = "seat") int seat,
                                        @Param(value = "sessionId") Long sessionId,
                                        @Param(value = "movieId") Long movieId);

    @Modifying
    @Transactional
    @Query(value = "update Ticket t set t.user.id = :userId " +
            "where t.id = :ticketId")
    void updateUserId(@Param(value = "ticketId") Long ticketId,
                      @Param(value = "userId") Long userId);

    @Query(value = "select t from Ticket t " +
            "where t.user.id = :userId")
    List<Ticket> findTicketsByUserId(@Param(value = "userId")
                                         Long userId);
}
