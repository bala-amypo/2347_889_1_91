package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.impl.CategorizationEngineServiceImpl;
import com.example.demo.service.impl.TicketServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketServiceImpl ticketService;
    private final CategorizationEngineServiceImpl engineService;

    public TicketController(
            TicketServiceImpl ticketService,
            CategorizationEngineServiceImpl engineService) {
        this.ticketService = ticketService;
        this.engineService = engineService;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PostMapping("/{id}/categorize")
    public void categorize(@PathVariable Long id) {
        engineService.categorizeTicket(id);
    }

    @GetMapping("/{id}")
    public Ticket get(@PathVariable Long id) {
        return ticketService.getTicket(id);
    }
}
