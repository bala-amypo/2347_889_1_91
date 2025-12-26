package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {   // ✅ interface
        this.service = service;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return service.createTicket(ticket);
    }

    @GetMapping("/{id}")
    public Ticket get(@PathVariable Long id) {
        return service.getTicket(id);
    }

    @GetMapping
    public List<Ticket> getAll() {
        return service.getAllTickets();
    }
}
