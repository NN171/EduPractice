package org.example.summerpracticesecondyear.service.impl;

import org.example.summerpracticesecondyear.entities.Session;
import org.example.summerpracticesecondyear.entities.Ticket;
import org.example.summerpracticesecondyear.entities.User;
import org.example.summerpracticesecondyear.repositories.SessionRepository;
import org.example.summerpracticesecondyear.repositories.TicketRepository;
import org.example.summerpracticesecondyear.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class TicketServiceImpl {

    private final TicketRepository ticketRepo;
    private final SessionRepository sessionRepo;
    private final UserRepository userRepo;

    public TicketServiceImpl(TicketRepository ticketRepo, SessionRepository sessionRepo, UserRepository userRepo) {
        this.ticketRepo = ticketRepo;
        this.sessionRepo = sessionRepo;
        this.userRepo = userRepo;
    }

    public double refundByUserId(Long userId, Long ticketId) throws NullPointerException {
        Session session = sessionRepo.findById(userId).orElse(null);
        long timeLeft = Math.abs(ChronoUnit.MINUTES.between(session.getStartTime(), LocalDateTime.now()));
        User existingUser = null;

        if (timeLeft > 30) {
            ticketRepo.refundTicketByUserId(userId, ticketId);
        }
        else {
            ticketRepo.refundTicketByUserId(userId, ticketId);
            User user = userRepo.findById(userId).orElse(null);
            user.setBonusBalance(user.getBonusBalance() + session.getMoviePrice() * 0.8);

            existingUser = userRepo.save(user);

        }
        return existingUser.getBonusBalance();
    }
}
