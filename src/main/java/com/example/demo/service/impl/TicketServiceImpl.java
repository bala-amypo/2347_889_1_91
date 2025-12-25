package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;

public class TicketServiceImpl {

    private final TicketRepository repo;

    public TicketServiceImpl(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket createTicket(Ticket t) {
        return repo.save(t);
    }

    public Ticket getTicket(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
    }
}
