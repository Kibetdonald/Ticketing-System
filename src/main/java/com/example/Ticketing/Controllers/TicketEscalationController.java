package com.example.Ticketing.Controllers;

import com.example.Ticketing.Models.TicketEscalation;
import com.example.Ticketing.Services.TicketEscalationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/ticket-escalations")

public class TicketEscalationController {

    @Autowired
    private TicketEscalationService ticketEscalationService;

    @GetMapping("/")
    public ResponseEntity<List<TicketEscalation>> findAll() {
        List<TicketEscalation> ticketEscalations = ticketEscalationService.findAll();
        return new ResponseEntity<>(ticketEscalations, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TicketEscalation> create(@RequestBody TicketEscalation ticketEscalation) {
        TicketEscalation createdTicketEscalation = ticketEscalationService.create(ticketEscalation);
        return new ResponseEntity<>(createdTicketEscalation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketEscalation> findById(@PathVariable Integer id) {
        TicketEscalation ticketEscalation = ticketEscalationService.findById(id);
        if (ticketEscalation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketEscalation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        TicketEscalation ticketEscalation = ticketEscalationService.findById(id);
        if (ticketEscalation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ticketEscalationService.delete(ticketEscalation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketEscalation> update(@PathVariable Integer id, @RequestBody TicketEscalation ticketEscalation) {
        TicketEscalation existingTicketEscalation = ticketEscalationService.findById(id);
        if (existingTicketEscalation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingTicketEscalation.setTicket(ticketEscalation.getTicket());
        existingTicketEscalation.setUser(ticketEscalation.getUser());
        existingTicketEscalation.setEscalatedAt(ticketEscalation.getEscalatedAt());
        existingTicketEscalation.setEscalationReason(ticketEscalation.getEscalationReason());
        existingTicketEscalation.setResolvedAt(ticketEscalation.getResolvedAt());
        TicketEscalation updatedTicketEscalation = ticketEscalationService.update(existingTicketEscalation);
        return new ResponseEntity<>(updatedTicketEscalation, HttpStatus.OK);
    }
}