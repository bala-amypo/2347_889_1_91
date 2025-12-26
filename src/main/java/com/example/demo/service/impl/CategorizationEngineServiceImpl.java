package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorizationEngineServiceImpl
        implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository urgencyPolicyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategoryRepository categoryRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository urgencyPolicyRepository,
            CategorizationLogRepository logRepository,
            TicketCategorizationEngine engine) {

        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ruleRepository = ruleRepository;
        this.urgencyPolicyRepository = urgencyPolicyRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    @Override
    public CategorizationLog categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();

        CategorizationLog log = engine.categorize(
                ticket,
                categoryRepository.findAll(),   // ✅ FIXED
                ruleRepository.findAll(),
                urgencyPolicyRepository.findAll()
        );

        return logRepository.save(log);
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId); // ✅ FIXED
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId).orElseThrow();
    }
}
