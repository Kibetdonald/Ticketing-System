package com.example.Ticketing.Models;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.List;

@Entity
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany()
    private List<Ticket> tickets;

    // getters and setters
}

