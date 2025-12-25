package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.impl.CategorizationEngineServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorization")
public class CategorizationEngineController {

    private final CategorizationEngineServiceImpl service;

    public CategorizationEngineController(CategorizationEngineServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/run/{ticketId}")
    public Ticket run(@PathVariable Long ticketId) {
        return service.categorizeTicket(ticketId);
    }

    @GetMapping("/logs/{ticketId}")
    public List<CategorizationLog> logs(@PathVariable Long ticketId) {
        return service.getLogsForTicket(ticketId);
    }
}
