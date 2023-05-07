package com.example.Ticketing.Services;

import com.example.Ticketing.Models.Ticket;
import com.example.Ticketing.Models.TicketEscalation;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketEscalationService {
    TicketEscalation create(TicketEscalation ticketEscalation);
    List<TicketEscalation> findAll();
    TicketEscalation findById(Integer id);
    void delete(TicketEscalation ticketEscalation);
    TicketEscalation update(TicketEscalation ticketEscalation);
}

