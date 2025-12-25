package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.TicketCategorizationEngine;
import java.util.*;

public class CategorizationEngineServiceImpl {

    private final TicketRepository ticketRepo;
    private final CategoryRepository categoryRepo;
    private final CategorizationRuleRepository ruleRepo;
    private final UrgencyPolicyRepository policyRepo;
    private final CategorizationLogRepository logRepo;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository t,
            CategoryRepository c,
            CategorizationRuleRepository r,
            UrgencyPolicyRepository p,
            CategorizationLogRepository l,
            TicketCategorizationEngine e) {

        ticketRepo = t; categoryRepo = c;
        ruleRepo = r; policyRepo = p;
        logRepo = l; engine = e;
    }

    public Ticket categorizeTicket(Long id) {
        Ticket t = ticketRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        List<CategorizationLog> logs = new ArrayList<>();
        engine.categorize(
                t,
                categoryRepo.findAll(),
                ruleRepo.findAll(),
                policyRepo.findAll(),
                logs
        );

        ticketRepo.save(t);
        logRepo.saveAll(logs);
        return t;
    }

    public List<CategorizationLog> getLogsForTicket(Long id) {
        return logRepo.findByTicket_Id(id);
    }

    public CategorizationLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}
