package org.example.summerpracticesecondyear.service.impl;

import org.example.summerpracticesecondyear.dto.TicketInfoDto;
import org.example.summerpracticesecondyear.entities.Ticket;
import org.example.summerpracticesecondyear.exceptions.SeatException;
import org.example.summerpracticesecondyear.exceptions.TicketNotFoundException;
import org.example.summerpracticesecondyear.projections.MovieType;
import org.example.summerpracticesecondyear.projections.TicketType;
import org.example.summerpracticesecondyear.repositories.MovieRepository;
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

    public UserServiceImpl(UserRepository userRepo, MovieRepository movieRepo, TicketRepository ticketRepo) {
        this.userRepo = userRepo;
        this.movieRepo = movieRepo;
        this.ticketRepo = ticketRepo;
    }

    @Override
    public List<MovieType> selectCompilationListByUserId(Long userId) {
        String genre = userRepo.findGenreByUserId(userId);

        return movieRepo.getMoviesByGenre(genre);
    }

    @Override
    public void ticketOrdering(TicketInfoDto ticketInfoDto) {
        int seat = ticketInfoDto.getSeat();
        Long sessionId = ticketInfoDto.getSessionId();
        Long movieId = ticketInfoDto.getMovieId();

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
    public List<TicketType> findTicketsByUserId(Long userId) {
        return ticketRepo.findTicketsByUserId(userId);
    }
}
