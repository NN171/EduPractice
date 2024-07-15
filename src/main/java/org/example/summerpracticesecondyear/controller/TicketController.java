package org.example.summerpracticesecondyear.controller;

import org.example.summerpracticesecondyear.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketServiceImpl ticketServiceImpl;

    @Autowired
    public TicketController(TicketServiceImpl ticketServiceImpl) {
        this.ticketServiceImpl = ticketServiceImpl;
    }

    @PutMapping("/{userId}/{movieId}")
    public double refundTicket(@PathVariable Long userId, @PathVariable Long movieId) {
        return ticketServiceImpl.refundByUserId(userId, movieId);
    }
}
