package org.example.summerpracticesecondyear.service;

import org.example.summerpracticesecondyear.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepo;

    public long count() {
        return ticketRepo.count();
    }
}
