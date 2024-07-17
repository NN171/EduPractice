package org.example.summerpracticesecondyear.service;

public interface TicketService {
    boolean isRefund(Long ticketId);
    void refundByUserId(Long userId, Long ticketId);
    double findBalanceByUserId(Long userId);
}
