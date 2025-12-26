package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.CategorizationEngineService;

@RestController
@RequestMapping("/engine")
public class CategorizationEngineController {

    private final CategorizationEngineService engineService;

    public CategorizationEngineController(CategorizationEngineService engineService) {
        this.engineService = engineService;
    }

    @PostMapping("/categorize/{ticketId}")
    public Ticket categorizeTicket(@PathVariable Long ticketId) {
        return engineService.categorizeTicket(ticketId);
    }

    @GetMapping("/logs")
    public List<CategorizationLog> getAllLogs() {
        return engineService.getAllLogs();
    }

    @GetMapping("/logs/{id}")
    public CategorizationLog getLogById(@PathVariable Long id) {
        return engineService.getLog(id);
    }
}
