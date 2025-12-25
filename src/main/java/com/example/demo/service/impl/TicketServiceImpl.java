package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return repository.save(ticket);
    }

    @Override
    public Ticket getTicket(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket not found"));
    }

    @Override
    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }
}
