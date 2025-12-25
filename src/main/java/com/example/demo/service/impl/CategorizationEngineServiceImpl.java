package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Ticket;
import com.example.demo.model.Category;
import com.example.demo.model.CategorizationLog;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.UrgencyPolicyRepository;
import com.example.demo.repository.CategorizationLogRepository;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

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

        this.ticketRepo = t;
        this.categoryRepo = c;
        this.ruleRepo = r;
        this.policyRepo = p;
        this.logRepo = l;
        this.engine = e;
    }

    @Override
    public void categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        List<CategorizationLog> logs = new ArrayList<>();

        engine.categorize(
                ticket,
                categoryRepo.findAll(),
                ruleRepo.findAll(),
                policyRepo.findAll(),
                logs
        );

        ticketRepo.save(ticket);
        logRepo.saveAll(logs);
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepo.findByTicket_Id(ticketId);
    }

    @Override
    public CategorizationLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}
