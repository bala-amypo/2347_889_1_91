package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return service.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket> all() {
        return service.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket one(@PathVariable Long id) {
        return service.getTicket(id);
    }
}
