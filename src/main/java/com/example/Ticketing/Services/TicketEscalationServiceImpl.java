package com.example.Ticketing.Services;

import com.example.Ticketing.Models.Ticket;
import com.example.Ticketing.Models.TicketEscalation;
import com.example.Ticketing.Repository.TicketEscalationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketEscalationServiceImpl implements TicketEscalationService {

    @Autowired
    private TicketEscalationRepository ticketEscalationRepository;

    @Override
    public TicketEscalation create(TicketEscalation ticketEscalation) {
        return ticketEscalationRepository.save(ticketEscalation);
    }
    @Override
    public List<TicketEscalation> findAll() {
        return ticketEscalationRepository.findAll();
    }
    @Override
    public TicketEscalation findById(Integer id) {
        return ticketEscalationRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(TicketEscalation ticketEscalation) {
        ticketEscalationRepository.delete(ticketEscalation);
    }

    @Override
    public TicketEscalation update(TicketEscalation ticketEscalation) {
        return ticketEscalationRepository.save(ticketEscalation);
    }
}

