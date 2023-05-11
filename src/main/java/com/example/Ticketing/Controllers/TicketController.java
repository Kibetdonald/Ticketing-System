package com.example.Ticketing.Controllers;

import com.example.Ticketing.Models.Ticket;
import com.example.Ticketing.Services.EmailService;
import com.example.Ticketing.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private EmailService emailService;

    @GetMapping("")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);

        // Send email notification
        String to = createdTicket.getUser().getEmail();
        String subject = "Ticket Created";
        String body = "Your ticket has been created with ID: " + createdTicket.getId();
        emailService.sendEmail(to, subject, body);

        return createdTicket;
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Ticket updatedTicket = ticketService.updateTicket(id, ticketDetails);

        // Send email notification
        String to = updatedTicket.getUser().getEmail();
        String subject = "Ticket Updated";
        String body = "Your ticket with ID: " + updatedTicket.getId() + " has been updated";
        emailService.sendEmail(to, subject, body);

        return updatedTicket;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok().build();
    }
}
