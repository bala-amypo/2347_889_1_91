package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketCategorizationEngine;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/engine")
public class TicketCategorizationEngineController {

    private final TicketCategorizationEngine engine;

    public TicketCategorizationEngineController(
            TicketCategorizationEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/categorize/{ticketId}")
    public Ticket categorize(@PathVariable Long ticketId) {
        return engine.categorize(ticketId);
    }
}
