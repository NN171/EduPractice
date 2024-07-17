package org.example.summerpracticesecondyear.service;

public interface TicketService {
    boolean isRefund(Long ticketId, Long userId);
    void refundByUserId(Long userId, Long ticketId);
    double findBalanceByUserId(Long userId);
    boolean isMatch(Long ticketId, Long userId);
}
