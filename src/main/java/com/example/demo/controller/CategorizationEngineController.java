package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.service.CategorizationEngineService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorization")
public class CategorizationEngineController {

    private final CategorizationEngineService service;

    public CategorizationEngineController(CategorizationEngineService service) {
        this.service = service;
    }

    @PostMapping("/{ticketId}")
    public CategorizationLog categorize(@PathVariable Long ticketId) {
        return service.categorizeTicket(ticketId);
    }

    @GetMapping("/ticket/{ticketId}")
    public List<CategorizationLog> getLogs(@PathVariable Long ticketId) {
        return service.getLogsForTicket(ticketId);
    }
}
