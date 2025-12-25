package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;

import java.util.List;

public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository policyRepository;
    private final CategorizationLogRepository logRepository;

    private final TicketCategorizationEngine engine =
            new TicketCategorizationEngine();

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository policyRepository,
            CategorizationLogRepository logRepository) {

        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.policyRepository = policyRepository;
        this.logRepository = logRepository;
    }

    @Override
    public Ticket categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket not found"));

        List<CategorizationRule> rules = ruleRepository.findAll();
        List<UrgencyPolicy> policies = policyRepository.findAll();

        TicketCategorizationEngine.CategorizationResult result =
                engine.categorize(ticket, rules, policies);

        ticket.setUrgencyLevel(result.getUrgency());
        ticketRepository.save(ticket);

        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setAppliedRule(result.getRule());
        log.setAssignedCategory(result.getCategory());
        log.setAssignedUrgency(result.getUrgency());

        logRepository.save(log);

        return ticket;
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    @Override
    public CategorizationLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Log not found"));
    }
}
