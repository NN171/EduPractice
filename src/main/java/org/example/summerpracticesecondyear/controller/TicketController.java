package org.example.summerpracticesecondyear.controller;

import org.example.summerpracticesecondyear.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketServiceImpl ticketServiceImpl;

    @Autowired
    public TicketController(TicketServiceImpl ticketServiceImpl) {
        this.ticketServiceImpl = ticketServiceImpl;
    }

    @GetMapping("/{userId}/{movieId}")
    public double refundTicket(@PathVariable Long userId, @PathVariable Long movieId) {
        ticketServiceImpl.refundByUserId(userId, movieId);
        return ticketServiceImpl.findBalanceByUserId(userId);
    }
}
