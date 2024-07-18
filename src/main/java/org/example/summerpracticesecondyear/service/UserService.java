package org.example.summerpracticesecondyear.service;

import org.example.summerpracticesecondyear.dto.MovieDto;
import org.example.summerpracticesecondyear.dto.TicketDto;
import org.example.summerpracticesecondyear.dto.TicketInfoDto;

import java.util.List;

public interface UserService {
    List<MovieDto> selectCompilationListByUserId(Long UserId);

    void ticketOrdering(TicketInfoDto ticketInfoDto);

    boolean seatIsAvailable(int seat, Long sessionId, Long movieId);

    List<TicketDto> findTicketsByUserId(Long userId);
}
