package org.example.summerpracticesecondyear.service;

import org.example.summerpracticesecondyear.entities.Ticket;
import org.example.summerpracticesecondyear.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepo;

    public long countByMovieId(int movieId) {
        return ticketRepo.findByMovieId(movieId).stream().count();
    }
}
