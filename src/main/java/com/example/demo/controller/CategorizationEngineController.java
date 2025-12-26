package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorization")
public class CategorizationEngineController {

    @Autowired
    private CategorizationEngineService categorizationEngineService;

    // Endpoint to categorize a ticket
    @PostMapping("/categorize")
    public CategorizationLog categorizeTicket(
            @RequestParam Long ticketId,
            @RequestParam Long categoryId,
            @RequestParam Long urgencyPolicyId) {

        return categorizationEngineService.categorizeTicket(ticketId, categoryId, urgencyPolicyId);
    }
}
