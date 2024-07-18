package org.example.summerpracticesecondyear.service.impl;

import org.example.summerpracticesecondyear.dto.MovieDto;
import org.example.summerpracticesecondyear.dto.TicketDto;
import org.example.summerpracticesecondyear.dto.TicketInfoDto;
import org.example.summerpracticesecondyear.entities.Ticket;
import org.example.summerpracticesecondyear.exceptions.MovieNotFoundException;
import org.example.summerpracticesecondyear.exceptions.SeatException;
import org.example.summerpracticesecondyear.exceptions.SessionNotFoundException;
import org.example.summerpracticesecondyear.exceptions.TicketNotFoundException;
import org.example.summerpracticesecondyear.mappers.MovieMapper;
import org.example.summerpracticesecondyear.mappers.TicketMapper;
import org.example.summerpracticesecondyear.repositories.MovieRepository;
import org.example.summerpracticesecondyear.repositories.SessionRepository;
import org.example.summerpracticesecondyear.repositories.TicketRepository;
import org.example.summerpracticesecondyear.repositories.UserRepository;
import org.example.summerpracticesecondyear.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final MovieRepository movieRepo;
    private final TicketRepository ticketRepo;
    private final SessionRepository sessionRepo;

    public UserServiceImpl(UserRepository userRepo, MovieRepository movieRepo,
                           TicketRepository ticketRepo, SessionRepository sessionRepo) {
        this.userRepo = userRepo;
        this.movieRepo = movieRepo;
        this.ticketRepo = ticketRepo;
        this.sessionRepo = sessionRepo;
    }

    @Override
    public List<MovieDto> selectCompilationListByUserId(Long userId) {
        String genre = userRepo.findGenreByUserId(userId);
        return MovieMapper.movieClassToMovieDto(movieRepo.getMoviesByGenre(genre));
    }

    @Override
    public void ticketOrdering(TicketInfoDto ticketInfoDto) {
        int seat = ticketInfoDto.getSeat();
        Long sessionId = ticketInfoDto.getSessionId();
        Long movieId = ticketInfoDto.getMovieId();
        movieRepo.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie doesn't exist"));
        sessionRepo.findById(sessionId).orElseThrow(() -> new SessionNotFoundException("Session doesn't exist"));

        if (seatIsAvailable(seat, sessionId, movieId)) {
            Long ticketId = ticketRepo.findTicketIdForOrderingService(seat, sessionId, movieId);
            Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() -> new TicketNotFoundException("Ticket doesn't exist"));
            ticketRepo.updateUserId(ticketId, ticketInfoDto.getUserId());
            ticketRepo.save(ticket);
        } else throw new SeatException("Seat doesn't exist");
    }

    @Override
    public boolean seatIsAvailable(int seat, Long sessionId, Long movieId) {
        if (ticketRepo.findUserIdForOrderingService(seat, sessionId, movieId) != null) {
            throw new SeatException("This seat is already reserved");
        }
        return true;
    }

    @Override
    public List<TicketDto> findTicketsByUserId(Long userId) {
        return TicketMapper.ticketClassToTicketDto(ticketRepo.findTicketsByUserId(userId));
    }
}
