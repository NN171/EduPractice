package org.example.summerpracticesecondyear.service;

import org.example.summerpracticesecondyear.dto.TicketInfoDto;
import org.example.summerpracticesecondyear.projections.MovieType;
import org.example.summerpracticesecondyear.projections.TicketType;

import java.util.List;

public interface UserService {
    List<MovieType> selectCompilationListByUserId(Long UserId);

    void ticketOrdering(TicketInfoDto ticketInfoDto);

    boolean seatIsAvailable(int seat, Long sessionId, Long movieId);

    List<TicketType> findTicketsByUserId(Long userId);
}
