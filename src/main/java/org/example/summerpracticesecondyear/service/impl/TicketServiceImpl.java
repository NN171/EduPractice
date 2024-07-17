package org.example.summerpracticesecondyear.service.impl;

import org.example.summerpracticesecondyear.entities.Session;
import org.example.summerpracticesecondyear.entities.Ticket;
import org.example.summerpracticesecondyear.entities.User;
import org.example.summerpracticesecondyear.exceptions.TicketNotFoundException;
import org.example.summerpracticesecondyear.exceptions.UserNotFoundException;
import org.example.summerpracticesecondyear.repositories.TicketRepository;
import org.example.summerpracticesecondyear.repositories.UserRepository;
import org.example.summerpracticesecondyear.service.TicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepo;
    private final UserRepository userRepo;

    public TicketServiceImpl(TicketRepository ticketRepo, UserRepository userRepo) {
        this.ticketRepo = ticketRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void refundByUserId(Long userId, Long ticketId) {
        Session session = ticketRepo.findSessionByTicketId(ticketId);

        long timeLeft = ChronoUnit.MINUTES.between(session.getStartTime(), LocalDateTime.now());

        if (!isRefund(ticketId) && timeLeft > 0) {
            if (timeLeft > 30) {
                ticketRepo.refundTicketByUserIdAndTicketId(ticketId);
            } else {
                ticketRepo.refundTicketByUserIdAndTicketId(ticketId);
                User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User doesn't exist"));
                user.setBonusBalance(user.getBonusBalance() + session.getMoviePrice() * 0.8);
                userRepo.save(user);
            }
        }
        else {
            throw new TicketNotFoundException("Session expired");
        }
    }

    @Override
    public boolean isRefund(Long ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() -> new TicketNotFoundException("Ticket doesn't exist"));

        return ticket.isRefund();
    }

    @Override
    public double findBalanceByUserId(Long userId) {
        return userRepo.findBalanceByUserId(userId);
    }
}
