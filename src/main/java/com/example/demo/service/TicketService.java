package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Ticket;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicket(Long id);
}
