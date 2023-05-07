package com.example.Ticketing.Repository;

import com.example.Ticketing.Models.TicketEscalation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketEscalationRepository extends JpaRepository<TicketEscalation, Integer> {
}
