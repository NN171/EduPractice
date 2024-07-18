package org.example.summerpracticesecondyear.controller;

import org.example.summerpracticesecondyear.service.TicketService;
import org.example.summerpracticesecondyear.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/refund")
    public String refundTicket(@RequestParam(value = "user_id") Long userId, @RequestParam(value = "ticket_id") Long ticketId) {
        ticketService.refundByUserId(userId, ticketId);
        return "Bonus balance of user " + userId.toString() + " is " + ticketService.findBalanceByUserId(userId);
    }
}
