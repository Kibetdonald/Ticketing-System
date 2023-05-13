package com.example.Ticketing.Controllers;

import com.example.Ticketing.Models.Ticket;
import com.example.Ticketing.Models.User;
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

        User user = createdTicket.getUser();

        // Send email notification
        // Check if the user object exists and has a valid email address
        if (user != null && user.getEmail() != null) {
            String to = user.getEmail();
            String subject = "Ticket Created";
            String body = "Your ticket has been created with ID: " + createdTicket.getId();
            emailService.sendEmail(to, subject, body);
        }


        return createdTicket;
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Ticket updatedTicket = ticketService.updateTicket(id, ticketDetails);

        // Send email notification
        User user = updatedTicket.getUser();

        // Check if the user object exists and has a valid email address
        if (user != null && user.getEmail() != null) {
            String to = updatedTicket.getUser().getEmail();
            String subject = "Ticket Created";
            String body = "Your ticket has been created with ID: " + updatedTicket.getId();
            emailService.sendEmail(to, subject, body);
        }

        return updatedTicket;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok().build();
    }
}
