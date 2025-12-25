package com.example.demo.service.impl;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service 
public class TicketServiceImpl implements TicketService {

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket createTicket(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return tickets;
    }

    @Override
    public Ticket getTicketById(Long id) {
        return tickets.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteTicket(Long id) {
        tickets.removeIf(t -> t.getId().equals(id));
    }
}
